package com.demo.dmsystem.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/*
* 李平喆
* 2021/9/20 9:54
* security 配置文件
* */

@Configuration
@EnableWebSecurity
class Security extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").permitAll()
                .antMatchers("/js/**").permitAll()//html放行js
                .antMatchers("/student/**").hasRole("student")//学生
                .antMatchers("/aunt/**").hasRole("aunt")//宿管
                .antMatchers("/admin/**").hasRole("admin");//后台管理
        super.configure(http);
        http.formLogin().loginPage("/login").permitAll().failureUrl("/login_error");//login form
        http.logout().logoutSuccessUrl("/");//("/logout")
        http.rememberMe();//记住我
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("lpz")
                .password(new BCryptPasswordEncoder()
                        .encode("123456"))
                .roles("student");
    }

    /*
    * 李平喆
    *  2021/9/20 22：53
    * web放行js
    * */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/js/***");
    }
}