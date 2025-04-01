package com.kb.security.handler;

import com.kb.member.dto.Member;
import com.kb.security.util.JsonResponse;
import com.kb.security.util.JwtProcessor;
import com.kb.student.domain.Student;
import com.kb.student.mapper.StudentMapper;
import com.kb.teacher.dto.TeacherDTO;
import com.kb.teacher.mapper.TeacherMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private final JwtProcessor jwtProcessor;
    private final StudentMapper studentMapper;
    private final TeacherMapper teacherMapper;

    private void setJwtCookie(HttpServletResponse response, String jwt) {
        Cookie cookie = new Cookie("jwt", jwt);
        cookie.setHttpOnly(true); // 클라이언트에서 쿠키에 접근할 수 없게 설정
        cookie.setSecure(false); // HTTPS에서만 쿠키 전송 (개발 환경에서는 false로 설정할 수도 있음)
        cookie.setPath("/"); // 애플리케이션 전체에서 쿠키 사용
        cookie.setMaxAge(724 * 60 * 60); // 7일간 유효
        response.addCookie(cookie); // 응답에 쿠키 추가
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
        // 인증 결과 Principal
        Member member = (Member) authentication.getPrincipal();
        Long stdId = -1L;
        Long tchId = -1L;
        if(member.getAuthorities().contains("ROLE_STUDENT")) {
            Student student = studentMapper.selectStudentByUsernameAndName(member.getUsername(), member.getName());
            stdId = student.getStdId();
        } else if(member.getAuthorities().contains("ROLE_TEACHER")) {
            TeacherDTO teacherDTO = teacherMapper.selectByTeacherProfile(member.getUsername());
            tchId = teacherDTO.getTchId();
        }
        String token = jwtProcessor.generateToken(member.getUsername(), stdId, tchId);
        setJwtCookie(response, token);
        member.setToken(token);
        JsonResponse.send(response, member);
    }
}
