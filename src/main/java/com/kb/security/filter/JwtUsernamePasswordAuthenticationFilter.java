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

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.Collection;

@Slf4j
@Component
public class JwtUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // 스프링 생성자 주입을 통해 전달
    public JwtUsernamePasswordAuthenticationFilter(
            AuthenticationManager authenticationManager,
            LoginSuccessHandler loginSuccessHandler,
            LoginFailureHandler loginFailureHandler ) {
        super(authenticationManager);

        setFilterProcessesUrl("/api/auth/login");		          // POST 로그인 요청 url
        setAuthenticationSuccessHandler(loginSuccessHandler);	// 로그인 성공 핸들러 등록
        setAuthenticationFailureHandler(loginFailureHandler);  // 로그인 실패 핸들러 등록
    }

    // 로그인 요청 URL인 경우 로그인 작업 처리
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {


        log.info("Attempting authentication..."); // 필터가 호출되었는지 확인
        log.info("Request URI: " + request.getRequestURI()); // 로그로 요청 경로 확인


        // 요청 BODY의 JSON에서 id, password  LoginDTO
        LoginDTO login = LoginDTO.of(request);
        // 인증 토큰(UsernamePasswordAuthenticationToken) 구성
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(login.getUsername(), login.getPassword());

//        Authentication authenticate = getAuthenticationManager().authenticate(authenticationToken);
//        Collection<? extends GrantedAuthority> authorities = authenticate.getAuthorities();
//        boolean isTeacher = authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_TEACHER"));
//        boolean isStudent = authorities.stream().anyMatch(auth -> auth.getAuthority().equals("ROLE_STUDENT"));
//
//        if(request.getRequestURI().contains("/student/auth/login") && isTeacher) {
//            throw new BadCredentialsException("학생 로그인 페이지에서는 선생님 계정으로 불가");
//        }

        // AuthenticationManager에게 인증 요청
        return getAuthenticationManager().authenticate(authenticationToken);
//        return authenticate;
    }

}
