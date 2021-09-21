package com.demo.dmsystem.demo.bean;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class user implements UserDetails {
    private Integer user_id;
    private String username;
    private String password;
    private Boolean enabled;
    private Boolean locked;
    private List<role> roleList;

    public List<role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        ArrayList<SimpleGrantedAuthority> authorities = new ArrayList<>();

        //SimpleGrantedAuthority__封装角色信息
        for (role role : roleList) {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    //是否未过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //是否没有被锁定
    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    //密码是否未过期,同理
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //是否可用
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    @Override
    public String toString() {
        return "user{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", enabled=" + enabled +
                ", locked=" + locked +
                ", roleList=" + roleList +
                '}';
    }
}

