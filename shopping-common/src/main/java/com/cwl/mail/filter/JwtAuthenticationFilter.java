package com.cwl.mail.filter;

import com.cwl.mail.pojo.TbSeller;
import com.cwl.mail.utils.CommonResult;
import com.cwl.mail.utils.JwtTokenUtil;
import com.cwl.mail.utils.UserDetailImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthenticationFilter(String url, AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        setFilterProcessesUrl(url);//指定用户验证的url地址
    }

    //用户验证
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        //获取前端json数据，包含了用户名和密码
        try {
            TbSeller tbSeller = new ObjectMapper().readValue(request.getInputStream(), TbSeller.class);
            System.out.println("账号："+tbSeller.getSellerId());
            System.out.println("密码："+tbSeller.getPassword());

            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(tbSeller.getSellerId(),tbSeller.getPassword(),new ArrayList<>()));
        } catch (Exception e) {
            e.printStackTrace();
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(null,null,new ArrayList<>()));
        }

    }

    //成功验证的回调方法,主要是返回一个有效的jwt的token
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {

        response.setContentType("application/json;charset=UTF-8");
        PrintWriter out = response.getWriter();
        //获取认证的主题信息
        UserDetailImpl userDetail = (UserDetailImpl) authResult.getPrincipal();
        //生成token
        String tocken = JwtTokenUtil.createToken("gec",userDetail.getUsername(),1800L);
        System.out.println(tocken);
        out.write(new ObjectMapper().writeValueAsString(CommonResult.success(JwtTokenUtil.TOKEN_PREFIX+tocken)));
        out.flush();
        out.close();
    }

    //认证失败的回调方法
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        super.unsuccessfulAuthentication(request, response, failed);
        response.setContentType("application/json'charset=UTF-8");
        PrintWriter out = response.getWriter();
        System.out.println("failure exception:"+failed.getMessage());
        out.write(new ObjectMapper().writeValueAsString(CommonResult.failed("登录失败")));
        out.flush();
        out.close();
    }
}
