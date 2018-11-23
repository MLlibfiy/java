package com.shujia.mysql;

import com.shujia.mysql.userlogin.mvc.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 预编译sql执行器
 * 防止sql注入
 * 在sql执行之前会先发一个sql模板，后将数据发送过去
 */
public class Demo4 {
    public static void main(String[] args) {

        Connection connection = DBUtil.getConnection();

        String sql = "select * from user where username=? and password=?";
        PreparedStatement preparedStatement = null;
        try {
            //创建预编译sql执行器
            preparedStatement = connection.prepareStatement(sql);
            //给里面的问号设置值
            preparedStatement.setString(1, "张三");
            preparedStatement.setString(2, "123");
            //执行sql返回结果
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println(username + "\t" + password);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(connection, preparedStatement);
        }

    }
}
