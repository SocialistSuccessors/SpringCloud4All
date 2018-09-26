package com.lds.config;

import com.lds.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by n0049901 on 2018/9/26.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MyUserDetailsService myUserDetailsService;
    @Autowired
    MyAuthenctiationSuccessHandler myAuthenctiationSuccessHandler;
    @Autowired
    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
                .loginPage("/login.html")   //设置登陆页面
                .loginProcessingUrl("/basic/index") //自定义的登陆接口
                //.successHandler(myAuthenctiationSuccessHandler)  //自定义登陆成功处理
                //.failureHandler(myAuthenctiationFailureHandler) //自定义登陆失败处理
                .and()
                .authorizeRequests()     // 定义哪些URL需要被保护、哪些不需要被保护
                .antMatchers("/login.html").permitAll() //设置所有人都可以访问登陆页面
                .anyRequest()               // 任何请求,登录后可以访问
                .authenticated()
                .and()
                .csrf().disable();          //关闭csrf防护
    }
}
