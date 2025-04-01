package com.kb.Scheduled;

import com.kb.quiz.domain.Quiz;
import com.kb.quiz.service.QuizService;
import com.kb.salary.dto.Salary;
import com.kb.salary.mapper.SalaryMapper;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.mapper.StudentMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class ScheduledTasks {

    private final StudentMapper studentMapper;
    private final SalaryMapper salaryMapper;
    private final QuizService quizService;
    private final JobLauncher jobLauncher;
    private final Job maturityJob;
    private final Job salaryBatchJob;

    @Autowired
    public ScheduledTasks(
            StudentMapper studentMapper,
            SalaryMapper salaryMapper, QuizService quizService,
            JobLauncher jobLauncher,
            @Qualifier("maturityJob") Job job,
            @Qualifier("salaryBatchJob") Job salaryBatchJob
            ) {
        this.studentMapper = studentMapper;
        this.salaryMapper = salaryMapper;
        this.quizService = quizService;
        this.jobLauncher = jobLauncher;
        this.maturityJob = job;
        this.salaryBatchJob = salaryBatchJob;
    }

//
    @Scheduled(cron = "0 0 8 * * MON")
    public void giveSalaryToAllStudents() {
        List<StudentSalaryDTO> additionalSalaryStudentList = studentMapper.selectStudentAdditionalSalary();
        Salary salary = salaryMapper.selectSalary();
        studentMapper.updateAllStudentSeed(salary.getBaseSalary());

        for(StudentSalaryDTO dto : additionalSalaryStudentList) {
            studentMapper.updateStudentSeed(dto.getStdId(), salary.getAdditionalSalary());
        }
    }

    @Scheduled(cron = "0 * 22 * * *")
    public void depositInterest() {
        try {
            log.info("Starting Batch Job... Deposit Interest");
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis()) // 고유한 파라미터
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(maturityJob, params);
            log.info("Job Execution Status: " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Job failed: " + e.getMessage());
        }
    }

    @Scheduled(cron = "0 0 9 * * Mon")
    public void salaryUpdate() {
        try {
            log.info("Starting Batch Job... Salary Update {}, Thread ID: {}", System.currentTimeMillis(), Thread.currentThread().getId());
            JobParameters params = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis()) // 고유한 파라미터
                    .toJobParameters();

            JobExecution execution = jobLauncher.run(salaryBatchJob, params);
            log.info("Job Execution Status: " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Job failed: " + e.getMessage());
        }
    }

    @Scheduled(cron = "0 0 9 * * 1-5")
    public void quizAutoSave() {
        Quiz quiz = quizService.generateAndSaveQuiz();
        log.info("{}, Quiz: {}", LocalDateTime.now(), quiz);
    }
}
