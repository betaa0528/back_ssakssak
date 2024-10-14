package com.kb.teacher.mapper;

import com.kb.alarm.dto.TeacherProfile;
import com.kb.teacher.dto.TeacherDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TeacherMapper {

    void insertTeacher(TeacherDTO teacherDTO);

    String findTeacherIdByNameAndEmail(TeacherDTO teacherDTO);

    int checkTeacherAccount(TeacherDTO teacherDTO);

    void updateTeacherPassword(TeacherDTO teacherDTO);

    TeacherDTO selectByTeacherProfile(String username);
    String selectTchNameByTchId(long tchId);
}