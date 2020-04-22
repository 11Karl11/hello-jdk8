package hello.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author karl xie
 * Created on 2020-04-22 16:07
 */
public class Test {

    public static void main(String[] args) {
        String sql = "select * from user";
        try {
            //获取到数据库连接池的单例对象
            JdbcPool jdbcPool = JdbcPool.getJdbcPoolInstance();
            System.out.println("当前数据库连接池中的连接数：" + jdbcPool.getCurrConnectionNum());
            //从连接池中获取到一个数据库连接
            Connection connection = jdbcPool.getJdbcConnection();
            System.out.println("获取一个连接后的数据库连接池中的连接数：" + jdbcPool.getCurrConnectionNum());

            //创建PreparedStatement
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            //执行sql且获取ResultSet
            ResultSet resultSet = preparedStatement.executeQuery();
            //循环ResultSet获取其中数据
            while (resultSet.next()) {
                String id = resultSet.getString("id");
                String userName = resultSet.getString("user_name");
                System.out.println("id：" + id + ",userName：" + userName);
            }
            //最后释放连接，将资源交给连接池进行回收
            jdbcPool.releaseJdbcConnection(resultSet, preparedStatement, connection);
            System.out.println("将使用后的连接还给数据库连接池后的连接数：" + jdbcPool.getCurrConnectionNum());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}