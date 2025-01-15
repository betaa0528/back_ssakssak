package com.kb.batch.job;

import com.kb.depositAccount.domain.DepositAccount;
import com.kb.depositAccount.dto.DepositMaturity;
import com.kb.depositAccount.mapper.DepositAccountMapper;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.utils.Calculator;
import com.kb.utils.DepositCalculator;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class DepositBatch {
    private final int CHUNK_SIZE = 10;
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SqlSessionFactory sqlSessionFactory;
    private final DepositAccountMapper depositAccountMapper;
    private final StudentMapper studentMapper;

    public DepositBatch(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SqlSessionFactory sqlSessionFactory, DepositAccountMapper depositAccountMapper, StudentMapper studentMapper) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sqlSessionFactory = sqlSessionFactory;
        this.depositAccountMapper = depositAccountMapper;
        this.studentMapper = studentMapper;
    }


    @Bean
    public Job maturityJob() {
        return jobBuilderFactory.get("maturityJob")
                .start(maturityStep())
                .build();
    }

    @Bean
    public Step maturityStep() {
        return stepBuilderFactory.get("maturityStep")
                .<DepositMaturity, DepositMaturity>chunk(CHUNK_SIZE)
                .reader(maturityReader())
                .processor(maturityProcessor())
                .writer(maturityWriter())
                .build();
    }

    @Bean
    public MyBatisPagingItemReader<DepositMaturity> maturityReader() {
        return new MyBatisPagingItemReaderBuilder<DepositMaturity>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.kb.depositAccount.mapper.DepositAccountMapper.getMaturityDepositList")
                .parameterValues(Map.of("pageSize", CHUNK_SIZE, "offset", 0))
                .pageSize(CHUNK_SIZE)
                .build();
    }

    @Bean
    public ItemProcessor<DepositMaturity, DepositMaturity> maturityProcessor() {
        return maturity -> {
            maturity.setStatus('N');
            return maturity;
        };
    }

    @Bean
    public ItemWriter<DepositMaturity> maturityWriter() {
        return items -> items.forEach(deposit -> {
            depositAccountMapper.updateDepositAccountStatus(deposit.getAccountId());
            Calculator calculator = new Calculator(new DepositCalculator());
            int interest = calculator.calculator(deposit.getRate(), deposit.getDepositAmount(), deposit.getDepositPeriod());
            studentMapper.updateStudentSeed(deposit.getStdId(), interest);
        });
    }

}
