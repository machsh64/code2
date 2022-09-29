package day13;

import JDBC.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @program: code2
 * @author: Ren
 * @create: 2022-09-28 13:37
 * @description:
 **/
public class PersonTest {
    public static void main(String[] args) throws SQLException {
        String sql = "SELECT * FROM tb_user ORDER BY id";
        Connection connection = JdbcUtil.getConnection("itcast");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            int age = resultSet.getInt("age");
            String gender = resultSet.getString("gender");
            System.out.println(id + " " +name+ "\t\t" + age + "\t" + gender);
        }

        insert(1006,"ttt",23,"女");

        connection.close();
        statement.close();
        resultSet.close();
    }

    public static void insert (int id,String name,int age,String gender){
        String sql = "INSERT INTO tb_user(id,name,age,gender) VALUES(" + id + ",\'" + name + ",\'" + age + ",\'"+ gender + "\' )";
         
    }
}
