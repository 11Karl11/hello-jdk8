package hello.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author karl xie
 * Created on 2020-04-22 16:06
 */
public class JdbcPool {

    //使用静态内部类实现单例模式
    private JdbcPool() {
    }

    ;

    private static class SingleJdbcPool {
        public static final JdbcPool jdbcPool = new JdbcPool();
    }

    public static JdbcPool getJdbcPoolInstance() {
        return SingleJdbcPool.jdbcPool;
    }

    /**
     * mysql的jdbc驱动类
     */
    private static final String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
    /**
     * 初始化连接数
     */
    private static final int INIT_LINK_NUM = 30;
    /**
     * 最大连接数
     */
    private static final int MAX_LINK_NUM = 100;
    /**
     * 最小连接数
     */
    private static final int MIN_LINK_NUM = 10;

    /**
     * 正在被使用的数据库连接数量
     */
    private AtomicInteger CURR_USED_LINK_NUM = new AtomicInteger();

    /**
     * 并发数组集合类
     */
    private CopyOnWriteArrayList<Connection> jdbcConnectPool;

    {
        try {
            //加载mysql的jdbc驱动类
           //Class.forName(DRIVER_CLASS_NAME);
            //初始化承载连接的容器
            jdbcConnectPool = new CopyOnWriteArrayList();
            //以初始化连接数量生成对应数量的jdbc连接且放入jdbcConnectPool中
            JdbcConnect jdbcConnect = JdbcConnect.getJdbcConnectInstance();
            for (int i = 0; i < INIT_LINK_NUM; i++) {
                Connection tempConnection = jdbcConnect.getConnection();
                if (tempConnection != null) {
                    jdbcConnectPool.add(tempConnection);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return java.sql.Connection
     * @Description 同步方法，用于从连接池中获取数据库连接
     * @Param []
     **/
    public synchronized Connection getJdbcConnection() {
        //获取数据库连接，如果当前数据库连接池中没有
        if (jdbcConnectPool.isEmpty() && getAllConnectionNum() < MAX_LINK_NUM) {
            //获取JdbcConnect连接对象
            JdbcConnect jdbcConnect = JdbcConnect.getJdbcConnectInstance();
            //获取Connection
            Connection tempConnection = jdbcConnect.getConnection();
            //将创建好的连接放入连接池
            jdbcConnectPool.add(tempConnection);

        } else if (jdbcConnectPool.isEmpty() && getAllConnectionNum() >= MAX_LINK_NUM) {
            //如果当前数据库连接池为空且连接总数已经超出最大值，则抛错
            throw new RuntimeException("当前数据库连接池中没有可用连接");
        }
        //获取最后一个connection连接
        Connection returnConnection = jdbcConnectPool.get(jdbcConnectPool.size() - 1);
        //然后移出刚才得到的连接
        jdbcConnectPool.remove(jdbcConnectPool.size() - 1);
        //当前正在被使用的连接数+1
        CURR_USED_LINK_NUM.getAndIncrement();
        return returnConnection;
    }

    /**
     * @return void
     * @Description 释放资源，按顺序首先释放ResultSet、Statement，然后再将使用结束的Conneection放回数据库连接池
     * @Param [resultSet, statement, connection]
     **/
    public synchronized void releaseJdbcConnection(ResultSet resultSet, Statement statement, Connection connection) {
        releaseJdbcStatementAndResultSet(resultSet, statement);
        //如果当前连接数小于最大连接数，则把数据库连接重新放置到数据库连接池中
        if (CURR_USED_LINK_NUM.get() > 0 && getAllConnectionNum() < MAX_LINK_NUM) {
            jdbcConnectPool.add(connection);
            CURR_USED_LINK_NUM.getAndDecrement();
        }
    }

    /**
     * @return void
     * @Description 按顺序释放ResultSet、Statement资源
     * @Param [resultSet, statement]
     **/
    public void releaseJdbcStatementAndResultSet(ResultSet resultSet, Statement statement) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (resultSet != null) {
                statement.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return int
     * @Description 获取当前数据库连接池中的连接数
     * @Param []
     **/
    public synchronized int getCurrConnectionNum() {
        return jdbcConnectPool.size();
    }

    /**
     * @return int
     * @Description 获取数据库连接池和正在被使用的连接的总和
     * @Param []
     **/
    public synchronized int getAllConnectionNum() {
        return jdbcConnectPool.size() + CURR_USED_LINK_NUM.get();
    }

}