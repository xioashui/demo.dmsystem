package com.demo.dmsystem.demo;

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
    /*
    author:李平喆
    time:2021/9/20
    describe:这是一个测试数据库连接，以及数据源的测试方法
    * */
    @Test
    void contextLoads() throws SQLException {
        System.out.println(dataSource.getClass());
        Connection connection=dataSource.getConnection();
        connection.close();
    }
}
