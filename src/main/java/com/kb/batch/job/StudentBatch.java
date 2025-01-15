package com.kb.batch.job;

import com.kb.student.dto.StudentDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
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
// TODO : TEST BATCH CODE WILL DELETE
@Slf4j
@Configuration
public class StudentBatch {
    private final int CHUNK_SIZE = 10;

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final SqlSessionFactory sqlSessionFactory;
    private final StudentMapper studentMapper;

    public StudentBatch(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory, SqlSessionFactory sqlSessionFactory, StudentMapper studentMapper) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.sqlSessionFactory = sqlSessionFactory;
        this.studentMapper = studentMapper;
    }

    @Bean
    public Job exampleJob() {
        log.info("@@@@@@@@@@@@@JOb 실행");
        return jobBuilderFactory.get("exampleJob")
                .start(exampleStep())
                .build();
    }


    @Bean
    public Step exampleStep() {
        log.info("Ste 실행");
        return stepBuilderFactory.get("exampleStep")
                .<StudentDTO, StudentDTO>chunk(CHUNK_SIZE)
                .reader(exampleReader())
                .processor(processor())
                .writer(writer())
                .build();
    }

    @Bean
    public MyBatisPagingItemReader<StudentDTO> exampleReader() {
        log.info("Reader 실행");
        return new MyBatisPagingItemReaderBuilder<StudentDTO>()
                .sqlSessionFactory(sqlSessionFactory)
                .queryId("com.kb.student.mapper.StudentMapper.getStudentListByJobId")
                .pageSize(CHUNK_SIZE)
                .build();
    }

    @Bean
    public ItemProcessor<StudentDTO, StudentDTO> processor() {
        log.info("@!!!!!!!!!!!!! 프로세서 작동중");

        return student -> {
            if (student != null) {
                log.info("Processing student: {}", student);
                student.setJobId(1);
                return student;
            }
            log.warn("Received null student in processor");
            return null;
        };
    }

    @Bean
    public ItemWriter<StudentDTO> writer() {
        log.info("writer작동중");
        return items -> {
            try {
                log.info("Writing items: {}", items);
                items.forEach(student -> {
                    log.info("Updating student: stdId={}, jobId={}", student.getStdId(), student.getJobId());
                    studentMapper.updateStudentJob(student.getStdId(), 2);
                });
            } catch (Exception e) {
                log.error("Error writing items: ", e);
            }

        };
    }

}
