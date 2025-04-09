package com.kb.student.mapper;

import com.kb.student.domain.Student;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentMapperTest {

    @Autowired
    private StudentMapper mapper;

    @Test
    void test() {
        Student student = mapper.selectStudentById(1020L);
        System.out.println(student);
    }

}