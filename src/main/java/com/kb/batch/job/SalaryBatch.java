package com.kb.batch.job;

import com.kb.salary.dto.SalaryBatchRequest;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.List;

@Slf4j
@Configuration
@EnableBatchProcessing
public class SalaryBatch {

    private final int CHUNK_SIZE = 10;

    private final SqlSessionFactory sqlSessionFactory;
    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    public SalaryBatch(SqlSessionFactory sqlSessionFactory, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        this.sqlSessionFactory = sqlSessionFactory;
        this.jobRepository = jobRepository;
        this.transactionManager = transactionManager;
    }


    @Bean
    public Job salaryBatchJob() {
        return new JobBuilder("salaryBatchJob", jobRepository)
                .start(salaryBatchStep())
                .build();
    }

    @Bean
    public Step salaryBatchStep() {
        return new StepBuilder("salaryBatchStep", jobRepository)
                .<SalaryBatchRequest, SalaryBatchRequest>chunk(CHUNK_SIZE, transactionManager)
                .reader(reader())
                .processor(processor())
                .writer(compositeWriter())
                .build();
    }

    @Bean
    public MyBatisPagingItemReader<SalaryBatchRequest> reader() {
        MyBatisPagingItemReader<SalaryBatchRequest> reader = new MyBatisPagingItemReader<>();
        reader.setSqlSessionFactory(sqlSessionFactory);
        reader.setQueryId("com.kb.salary.mapper.SalaryMapper.selectSalaryByTchId");
        reader.setPageSize(CHUNK_SIZE);
        return reader;
    }

    public ItemProcessor<SalaryBatchRequest, SalaryBatchRequest> processor() {
        return item -> {
            log.info("Processing item: {}", item);
            return item;
        };
    }

    @Bean
    public MyBatisBatchItemWriter<SalaryBatchRequest> salaryUpdateWriter() {
        MyBatisBatchItemWriter<SalaryBatchRequest> writer = new MyBatisBatchItemWriter<>();
        writer.setSqlSessionFactory(sqlSessionFactory);
        writer.setStatementId("com.kb.student.mapper.StudentMapper.updateStudentSalaryBatch");
        return writer;
    }

    @Bean
    @Transactional
    public MyBatisBatchItemWriter<SalaryBatchRequest> salaryLogWriter() {
        MyBatisBatchItemWriter<SalaryBatchRequest> batchItemWriter = new MyBatisBatchItemWriter<>();
        batchItemWriter.setSqlSessionFactory(sqlSessionFactory);
        batchItemWriter.setStatementId("com.kb.salary.mapper.SalaryMapper.insertSalaryHistory");
        return batchItemWriter;
    }

    @Bean
    @Transactional
    public CompositeItemWriter<SalaryBatchRequest> compositeWriter() {
        CompositeItemWriter<SalaryBatchRequest> writer = new CompositeItemWriter<>();
        writer.setDelegates(List.of(salaryUpdateWriter(), salaryLogWriter()));
        return writer;
    }
}

