package com.kb.security.filter;


import com.kb.member.dto.LoginDTO;
import com.kb.security.handler.LoginFailureHandler;
import com.kb.security.handler.LoginSuccessHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@Slf4j
@Component
public class JwtStudentAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // 스프링 생성자 주입을 통해 전달
    public JwtStudentAuthenticationFilter(
            AuthenticationManager authenticationManager,
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler ) {
        super(authenticationManager);

//        setFilterProcessesUrl("/api/auth/login");		          // POST 로그인 요청 url
        setFilterProcessesUrl("/api/student/auth/login");		          // POST 로그인 요청 url
//        setFilterProcessesUrl("/api/teacher/auth/login");		          // POST 로그인 요청 url
        setAuthenticationSuccessHandler(loginSuccessHandler);	// 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler);  // 로그인 실패 핸들러 등록
    }

    // 로그인 요청 URL인 경우 로그인 작업 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {



        log.info("학생 로그인 시도: " + request.getRequestURI());

        LoginDTO login = LoginDTO.of(request);

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

        Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);
        Collection<? extends GrantedAuthority> authorities = authenticate.getAuthorities();
        boolean isTeacher = authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_TEACHER"));

        // 학생 로그인 경로에서 선생님 계정으로 로그인 시도 시 예외 처리
        if (isTeacher) {
            throw new BadCredentialsException("학생 로그인 페이지에서는 선생님 계정으로 불가");
        }

        return authenticate;
    }

}
