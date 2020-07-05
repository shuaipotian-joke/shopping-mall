package com.cwl.mail.config;


import com.cwl.mail.component.RestAuthenticationEntryPoint;
import com.cwl.mail.component.RestAuthorizationHandler;
import com.cwl.mail.filter.JwtAuthorizationFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/doLogin")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //.addFilterBefore(new JwtAuthenticationFilter("/doLogin", authenticationManager()), UsernamePasswordAuthenticationFilter.class)   //用户认证， 成功和失败的回调
                .addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);  //资源的拦截的认证

        http.csrf().disable();
        http.headers().cacheControl();

        //报错处理组件
        http.exceptionHandling().accessDeniedHandler(new RestAuthorizationHandler())
                .authenticationEntryPoint(new RestAuthenticationEntryPoint());
    }
}
