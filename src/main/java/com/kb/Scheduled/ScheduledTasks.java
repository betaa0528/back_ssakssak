package com.kb.Scheduled;

import com.kb.salary.dto.Salary;
import com.kb.salary.mapper.SalaryMapper;
import com.kb.student.dto.StudentSalaryDTO;
import com.kb.student.mapper.StudentMapper;
import com.kb.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ScheduledTasks {

    private final StudentMapper studentMapper;
    private final SalaryMapper salaryMapper;
    private final JobLauncher jobLauncher;
    private final Job job;

    @Autowired
    public ScheduledTasks(StudentMapper studentMapper, SalaryMapper salaryMapper, JobLauncher jobLauncher, @Qualifier("maturityJob") Job job) {
        this.studentMapper = studentMapper;
        this.salaryMapper = salaryMapper;
        this.jobLauncher = jobLauncher;
        this.job = job;
    }

//
//    @Scheduled(cron = "0 0 8 * * MON")
//    public void giveSalaryToAllStudents() {
//        List<StudentSalaryDTO> additionalSalaryStudentList = studentMapper.selectStudentAdditionalSalary();
//        Salary salary = salaryMapper.selectSalary();
//        studentMapper.updateAllStudentSeed(salary.getBaseSalary());
//
//        for(StudentSalaryDTO dto : additionalSalaryStudentList) {
//            studentMapper.updateStudentSeed(dto.getStdId(), salary.getAdditionalSalary());
//        }
//    }

    @Scheduled(cron = "0 * * * * *")
    public void depositInterest() {
        try {
            System.out.println("Starting Batch Job...");
            JobExecution execution = jobLauncher.run(job, new JobParameters());
            log.info("Job Execution Status: " + execution.getStatus());
        } catch (Exception e) {
            e.printStackTrace();
            log.info("Job failed: " + e.getMessage());
        }
    }
}
