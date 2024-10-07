package com.kb.student.mapper;

import com.kb._config.RootConfig;
import com.kb.student.domain.Student;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@ContextConfiguration(classes = {RootConfig.class})
class StudentMapperTest {

    @Autowired
    private StudentMapper studentMapper;

    @Test
    @DisplayName("학생의 계정아이디와 이름으로 올바른 객체를 가져오는지 확인한다.")
    void selectStudentByUsernameAndStdNameTest() {
        Student student = studentMapper.selectStudentByUsernameAndStdName("minjup", "박민주");
        System.out.println(student);
    }

}