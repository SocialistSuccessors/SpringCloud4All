package com.lds.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.parameters.P;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;

/**
 * Created by n0049901 on 2018/9/26.
 */
public class User implements UserDetails{
    private String username;
    private String password;
    private List<GrantedAuthority> authorities;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
    public User(String username, String password, List<GrantedAuthority> admin) {
        this.username = username;
        this.password = password;
        this.authorities = admin;
    }
    // 封装了权限信息
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }
    //账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    //账户是否冻结
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    //帐户密码是否过期，一般有的密码要求性高的系统会使用到，比较每隔一段时间就要求用户重置密码
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    //帐号是否可用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
