package jdbc_Test.CRUD;

import JDBC.JDBCUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-30 15:13
 * @description:
 *
 * 使用PreparedStatement针对与不同表的查询操作
 **/
public class PreparedStatementQueryTest {

    public static void main(String[] args) {
        Connection conn = JDBCUtil.getConnection("test");
        String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_name = ?";
        Order order = getInstance(Order.class,conn,sql,"AA");
        System.out.println(order);
    }

    public static <T> T  getInstance(Class<T> clazz,Connection conn,String sql,Object ...args) {
        PreparedStatement preStatement = null;
        ResultSet resultSet = null;

        try {
            //连接数据库
            preStatement = conn.prepareStatement(sql);

            //填充占位符
            for (int i = 0; i < args.length; i++) {
                preStatement.setObject(i + 1, args[i]);
            }
            //获取结果集
            resultSet = preStatement.executeQuery();
            //获取结果集的元数据
            ResultSetMetaData rsmd = resultSet.getMetaData();
            //获取列数
            int columnCount = rsmd.getColumnCount();
            while (resultSet.next()) {
                T t = clazz.newInstance();
                for (int i = 0; i < columnCount; i++) {
                    //读取每个列的列值，通过ResultSet
                    Object columnValue = resultSet.getObject(i + 1);
                    //通过ResultMetaData
                    //获取列的列名 rsmd.getColumnName();    不推荐使用
                    //获取列的别名 rsmd.getColumnLabel();
                    /* String columnName = rsmd.getColumnName(i + 1);*/   //获取到的是表中的列名
                    String columnLabel = rsmd.getColumnLabel(i + 1);   //获取到的是sql语句中，所属表中的别名
                    //通过反射，将对象指定名赋值为指定的值
                    Field field = t.getClass().getDeclaredField(columnLabel);
                    field.setAccessible(true);
                    field.set(t, columnValue);
                }
                return t;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtil.release(conn, preStatement, resultSet);
        }
        return null;
    }
}
