package JDBC;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-27 09:37
 * @description:
 **/
public class JdbcUtil {
    static String driverClass;
    static String url1;
    static String url2;
    static String username;
    static String password;

    //配置文件，驱动注册封装
    static {
        try {
            Properties pro = new Properties();
            //加载配置文件
            pro.load(new FileInputStream("JDBC/jdbc"));
            //获取配置文件对应信息
            driverClass = pro.getProperty("driverClass");
            url1 = pro.getProperty("url1");
            url2 = pro.getProperty("url2");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
            //注册驱动
            Class.forName(driverClass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接封装
    public static Connection getConnection(String url) {
        Connection conn = null;
        try {
            //获取链接
            if (url.equals("loadsql")) {
                url = url1;
            }else if (url.equals("itcast")){
                url = url2;
            }else {
                throw new RuntimeException("配置文件中没有加载名为 " + url + " 的数据库");
            }
            conn = DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    //释放资源
    public static void release(Connection conn, Statement statement, ResultSet resultSet) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //创建该类时的快捷测试，可删除，但不建议，后续增加功能可在此处测试
    public static void main(String[] args) throws Exception {
        String sql = "SELECT * FROM tb_user ORDER BY id";
        //1，获取连接
        Connection conn = JdbcUtil.getConnection("itcast");
        //2，创建执行语句对象
        Statement statement = conn.createStatement();
        //3，执行语句
        ResultSet resultSet = statement.executeQuery(sql);
        //4，处理结果
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name= resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            System.out.println(id + " " + name + " " + age + " " + gender);
        }
        //5，关流
        JdbcUtil.release(conn,statement,resultSet);
    }
}
