package com.kb._config;

import com.kb.security.filter.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.annotation.MapperScan;
import com.kb.security.handler.CustomAccessDeniedHandler;
import com.kb.security.handler.CustomAuthenticationEntryPoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.util.List;

@Configuration
@EnableWebSecurity
@Log4j
//@ComponentScan(basePackages = {"com.kb.security"})
@RequiredArgsConstructor
public class SecurityConfig {

    private final AuthenticationErrorFilter authenticationErrorFilter;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final JwtTeacherAuthenticationFilter jwtTeacherAuthenticationFilter;
    private final JwtStudentAuthenticationFilter jwtStudentAuthenticationFilter;
    private final CustomAccessDeniedHandler accessDeniedHandler;
    private final CustomAuthenticationEntryPoint authenticationEntryPoint;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF 보호 비활성화
                .cors(cors -> cors.configurationSource(configurationSource())) // CORS 설정
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // 세션 정책 설정
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST, "/api/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/student/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/teacher/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/login/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/alarm/subscribe/**").permitAll()
                        .requestMatchers(HttpMethod.GET, "/hello", "/api/teacher/home/test/**").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(ex -> ex
                        .authenticationEntryPoint(authenticationEntryPoint)
                        .accessDeniedHandler(accessDeniedHandler)
                )
                .addFilterBefore(characterEncodingFilter(), UsernamePasswordAuthenticationFilter.class) // UTF-8 필터
                .addFilterBefore(authenticationErrorFilter, UsernamePasswordAuthenticationFilter.class) // 인증 에러 필터
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // JWT 인증 필터
                .addFilterBefore(jwtTeacherAuthenticationFilter, UsernamePasswordAuthenticationFilter.class) // JWT 선생님 필터
                .addFilterBefore(jwtStudentAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); // JWT 학생 필터

        return http.build(); // 필터 체인을 반환
    }

    @Bean
    public CorsConfigurationSource configurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://ssakssak.shop", "https://ssakssak.shop","http://localhost:21000", "http://ec2-13-209-69-73.ap-northeast-2.compute.amazonaws.com"));
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        configuration.setAllowedHeaders(List.of("*"));
        configuration.setAllowCredentials(true); // ✅ 이게 핵심

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 비밀번호 인코더 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // UTF-8 인코딩 필터
    @Bean
    public CharacterEncodingFilter characterEncodingFilter() {
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8");
        filter.setForceEncoding(true);
        return filter;
    }
}
