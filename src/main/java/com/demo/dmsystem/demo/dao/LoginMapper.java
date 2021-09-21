package com.demo.dmsystem.demo.dao;

import com.demo.dmsystem.demo.bean.role;
import com.demo.dmsystem.demo.bean.user;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface LoginMapper {

    /*
    * 李平喆
    * 2021/9/21 12：29
    * */
    public user getuserbyusername(String username);

    /*
    * 连接查询
    * */
    public role getRoleByRole_id(String role_id);
}
