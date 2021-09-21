package com.demo.dmsystem.demo;

import com.demo.dmsystem.demo.dao.LoginMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class DemoApplicationTests {

    @Qualifier("dataSource")
    @Autowired
    DataSource dataSource;

    @Autowired
    LoginMapper loginMapper;

    /*
    李平喆
    2021/9/20
    这是一个测试数据库连接，以及数据源的测试方法,你可以运行该方法以测试数据源是否配对
    * */
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        connection.close();
    }

    /*
    * 李平喆
    * 测试sql，你可以运行此方法以测试sql语句是否正确*/
    @Test
    void mybatistest(){
        System.out.println(loginMapper.getuserbyusername("lpz"));
    }
}
