package com.demo.dmsystem.demo.config;

import com.demo.dmsystem.demo.service.imp.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/*
* 李平喆
* 2021/9/20 9:54
* security 配置文件
* */

@Configuration
@EnableWebSecurity
class Security extends WebSecurityConfigurerAdapter {

    /*
    * 李平喆
    * 2021/9/21 12:44
    * 重写默认认证方法,改用数据库认证
    * */
    @Autowired
    loginService loginService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/js/**").permitAll()//html放行js
                .antMatchers("/img/**").permitAll()//放行img
                .antMatchers("/student/**").hasRole("student")//学生
                .antMatchers("/aunt/**").hasRole("aunt")//宿管
                .antMatchers("/admin/**").hasRole("admin");//后台管理
        super.configure(http);
        http.formLogin().loginPage("/login").permitAll().failureUrl("/login_error");//login form
        http.logout().logoutSuccessUrl("/");//("/logout")
        http.rememberMe();//记住我
        http.csrf().disable();
    }

    /*
    * 李平喆
    * 2021/9/21 12：47 改用数据库认证
    * */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lpz")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("student");*/
        //改写认证
        auth.userDetailsService(loginService);
    }

    /*
    * 李平喆
    * 2021/9/21 12:52
    * 密码加密
    * */
    /*
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }*/

    /*
    *取消加密,官方不推荐
    * */
    @Bean
    NoOpPasswordEncoder noOpPasswordEncoder(){
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}