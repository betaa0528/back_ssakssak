package com.kb.teacher.service;

import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherMapper teacherMapper;
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public void signUpTeacher(TeacherDTO teacherDTO) {
        validatePassword(teacherDTO.getTchPw());
        teacherDTO.setTchPw(passwordEncoder.encode(teacherDTO.getTchPw()));
        teacherMapper.insertTeacher(teacherDTO);
    }

    public String findTeacherIdByNameAndEmail(TeacherDTO teacherDTO) {
        return teacherMapper.findTeacherIdByNameAndEmail(teacherDTO);
    }

    public boolean checkTeacherAccount(TeacherDTO teacherDTO) {
        return teacherMapper.checkTeacherAccount(teacherDTO) > 0;
    }

    public void resetTeacherPassword(TeacherDTO teacherDTO) {
        validatePassword(teacherDTO.getTchPw());
        teacherDTO.setTchPw(passwordEncoder.encode(teacherDTO.getTchPw()));
        teacherMapper.updateTeacherPassword(teacherDTO);
    }

    private void validatePassword(String password) {
        String passwordPattern = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,16}$";

        if (!Pattern.matches(passwordPattern, password)) {
            throw new IllegalArgumentException("Passwords must contain 8 to 16 characters of English case, case, numbers, and special characters");
        }
    }
}