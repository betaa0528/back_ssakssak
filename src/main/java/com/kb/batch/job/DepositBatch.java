package com.kb.batch.job;

import com.kb.depositAccount.dto.DepositMaturity;
import com.kb.depositAccount.mapper.DepositAccountMapper;
import com.kb.student.mapper.StudentMapper;
import com.kb.common.utils.Calculator;
import com.kb.common.utils.DepositCalculator;
import jakarta.transaction.Transactional;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class DepositBatch {
    private final int CHUNK_SIZE = 100;
    private final SqlSessionFactory sqlSessionFactory;
    private final DepositAccountMapper depositAccountMapper;
    private final StudentMapper studentMapper;

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public DepositBatch(SqlSessionFactory sqlSessionFactory, JobRepository jobRepository, PlatformTransactionManager transactionManager, DepositAccountMapper depositAccountMapper, StudentMapper studentMapper) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
        this.depositAccountMapper = depositAccountMapper;
        this.studentMapper = studentMapper;
    }



    @Bean
    public Job maturityJob() {
        return new JobBuilder("maturityJob", jobRepository)
                .start(maturityStep())
                .build();
    }

    @Bean
    public Step maturityStep() {
        return new StepBuilder("maturityStep", jobRepository)
                .<DepositMaturity, DepositMaturity>chunk(CHUNK_SIZE ,transactionManager)
                .reader(maturityReader())
                .processor(maturityProcessor())
                .writer(maturityWriter())
                .build();
    }

    @Bean
    public MyBatisPagingItemReader<DepositMaturity> maturityReader() {
        MyBatisPagingItemReader<DepositMaturity> reader = new MyBatisPagingItemReader<>();
        reader.setSqlSessionFactory(sqlSessionFactory);
        reader.setQueryId("com.kb.depositAccount.mapper.DepositAccountMapper.getMaturityDepositList");
        reader.setPageSize(CHUNK_SIZE);
        return reader;
    }

    @Bean
    public ItemProcessor<DepositMaturity, DepositMaturity> maturityProcessor() {
        return maturity -> {
            maturity.setStatus('N');
            return maturity;
        };
    }

    @Bean
    @Transactional
    public ItemWriter<DepositMaturity> maturityWriter() {
        return items -> items.forEach(deposit -> {
            depositAccountMapper.updateDepositAccountStatus(deposit.getAccountId());
            Calculator calculator = new Calculator(new DepositCalculator());
            int interest = calculator.calculator(deposit.getRate(), deposit.getDepositAmount(), deposit.getDepositPeriod());
            studentMapper.updateStudentSeed(deposit.getStdId(), interest);
        });
    }

}
