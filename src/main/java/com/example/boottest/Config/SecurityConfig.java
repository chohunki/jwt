package com.example.boottest.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring() //무시
                .antMatchers(
                        "/h2-console/**"
                        ,"/favicon.ico"
                ); //h2-console 하위 모든 요청들과 favicon 관련 요청은 Spring Security 로직을 수행하지 않도록 설정
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests() //HttpServletRequest를 사용하는 요청들에 대한 접근제한 설정
                .antMatchers("/api/hello").permitAll() // /api/hello에 대한 요청은 인증없이 접근 허용
                .anyRequest().authenticated(); //나머지는 모두 인증받아야 한다.
    }
}
