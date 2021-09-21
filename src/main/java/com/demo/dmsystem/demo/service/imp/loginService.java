package com.demo.dmsystem.demo.service.imp;

import com.demo.dmsystem.demo.bean.user;
import com.demo.dmsystem.demo.dao.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class loginService implements UserDetailsService {

    /*
    * 李平喆
    * 注入mapper映射
    * 2021/9/21 12:27
    * */
    @Autowired
    private LoginMapper loginMapper;

    /*
     * 李平喆
     * 登录认证
     * 2021/9/21 12:27
     * */

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        user user = loginMapper.getuserbyusername(s);
        if (user == null)
            throw new UsernameNotFoundException("error");
        return user;
    }
}
