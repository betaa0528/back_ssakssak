package com.kb.batch.job;

import com.kb.depositAccount.dto.DepositMaturity;
import com.kb.salary.dto.SalaryBatchRequest;
import com.kb.salary.dto.SalaryHistory;
import com.kb.student.domain.Student;
import com.kb.student.dto.UpdatedStudentSalary;
import com.kb.student.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.batch.MyBatisBatchItemWriter;
import org.mybatis.spring.batch.MyBatisPagingItemReader;
import org.mybatis.spring.batch.builder.MyBatisBatchItemWriterBuilder;
import org.mybatis.spring.batch.builder.MyBatisPagingItemReaderBuilder;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Slf4j
@Configuration
public class SalaryBatch {

    private final int CHUNK_SIZE = 10;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SqlSessionFactory sqlSessionFactory;

    public SalaryBatch(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SqlSessionFactory sqlSessionFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sqlSessionFactory = sqlSessionFactory;
    }

    @Bean
    public Job salaryBatchJob() {
        return jobBuilderFactory.get("salaryBatchJob")
                .start(salaryBatchStep())
                .build();
    }

    @Bean
    public Step salaryBatchStep() {
        return stepBuilderFactory.get("salaryBatchStep")
                .<SalaryBatchRequest, SalaryBatchRequest>chunk(CHUNK_SIZE)
                .reader(reader())
                .processor(processor())
                .writer(compositeWriter())
                .build();
    }

    @Bean
    public MyBatisPagingItemReader<SalaryBatchRequest> reader() {
        return new MyBatisPagingItemReaderBuilder<SalaryBatchRequest>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.kb.salary.mapper.SalaryMapper.selectSalaryByTchId")
                .pageSize(CHUNK_SIZE)
                .build();
    }


    public ItemProcessor<SalaryBatchRequest, SalaryBatchRequest> processor() {
        return item -> {
            log.info("Processing item: {}", item);
            return item;
        };
    }


    @Bean
    public MyBatisBatchItemWriter<SalaryBatchRequest> salaryUpdateWriter() {
        log.info("salary writer 오고 있나요?");
        return new MyBatisBatchItemWriterBuilder<SalaryBatchRequest>()
                .sqlSessionFactory(sqlSessionFactory)
                .statementId("com.kb.student.mapper.StudentMapper.updateStudentSalaryBatch")
                .build();
    }

    @Bean
    public MyBatisBatchItemWriter<SalaryBatchRequest> salaryLogWriter() {
        log.info("salary writer 오고 있나요?22222");
        MyBatisBatchItemWriter<SalaryBatchRequest> batchItemWriter = new MyBatisBatchItemWriter<>();
        batchItemWriter.setSqlSessionFactory(sqlSessionFactory);
        batchItemWriter.setStatementId("com.kb.salary.mapper.SalaryMapper.insertSalaryHistory");
        return batchItemWriter;
    }

    @Bean
    public CompositeItemWriter<SalaryBatchRequest> compositeWriter() {
        log.info("compositeWriter 실행함!!!!!!");
        CompositeItemWriter<SalaryBatchRequest> writer = new CompositeItemWriter<>();
        writer.setDelegates(List.of(salaryUpdateWriter(), salaryLogWriter()));
        return writer;
    }
}

