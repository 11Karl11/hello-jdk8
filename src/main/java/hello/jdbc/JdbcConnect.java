package hello.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author karl xie
 * Created on 2020-04-22 16:05
 */

public class JdbcConnect {

    //使用静态内部类实现单例模式
    private JdbcConnect() {
    }


    private static class SingleJdbcConnect {
        public static final JdbcConnect jdbcConnect = new JdbcConnect();
    }

    public static JdbcConnect getJdbcConnectInstance() {
        return SingleJdbcConnect.jdbcConnect;
    }


    private static final String URL = "jdbc:mysql://127.0.0.1:3306/test";
    private static final String NAME = "root";
    private static final String PASSWORD = "root";

    /**
     * @return java.sql.Connection
     * @Description 使用DriverManager获取数据库连接Connection
     * @Param []
     **/
    public synchronized Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, NAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * @return void
     * @Description 释放数据库连接Connection
     * @Param [connection]
     **/
    public synchronized void freeConnection(Connection connection) {
        try {
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}