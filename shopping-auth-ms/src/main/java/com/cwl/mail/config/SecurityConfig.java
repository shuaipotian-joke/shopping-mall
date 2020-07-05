package com.cwl.mail.config;


import com.cwl.mail.component.RestAuthenticationEntryPoint;
import com.cwl.mail.component.RestAuthorizationHandler;
import com.cwl.mail.filter.JwtAuthenticationFilter;
import com.cwl.mail.pojo.TbSeller;
import com.cwl.mail.service.SysUserService;
import com.cwl.mail.utils.UserDetailImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.util.ArrayList;
import java.util.Collection;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private SysUserService sysUserService;

    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return  new UserDetailsService() {

            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                System.out.println("帐号：" + username);
                TbSeller user = sysUserService.findUserByUsercode(username);
                if (user != null) {
                    Collection<? extends GrantedAuthority> authorities = new ArrayList<>();
                    return new UserDetailImpl(user, authorities );
                }
                throw new UsernameNotFoundException("帐号或密码错误");
            }
        };

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService());
    }

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
                .addFilterBefore(new JwtAuthenticationFilter("/doLogin", authenticationManager()), UsernamePasswordAuthenticationFilter.class);  //用户认证， 成功和失败的回调
                //.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);  //资源的拦截的认证

        http.csrf().disable();
        http.headers().cacheControl();

        //报错处理组件
        http.exceptionHandling().accessDeniedHandler(new RestAuthorizationHandler())
                .authenticationEntryPoint(new RestAuthenticationEntryPoint());
    }
}
