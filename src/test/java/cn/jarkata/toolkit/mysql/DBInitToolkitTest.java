package cn.jarkata.toolkit.mysql;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DBInitToolkitTest {

    @Test
    public void init() throws SQLException, IOException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/db_testdb");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        DBInitToolkit.init(dataSource);
    }
}