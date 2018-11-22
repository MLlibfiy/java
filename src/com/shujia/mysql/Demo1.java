package com.shujia.mysql;


import java.sql.*;

/**
 * 连接mysql数据库
 */
public class Demo1 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        try {
            //1、加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            //2、建立连接
            connection = DriverManager.getConnection("jdbc:mysql://node1:3306/test", "root", "123456");

            //3|获取sql执行器
            statement = connection.createStatement();

            String sql = "select * from info";
            //4、执行sql，返回结果
            ResultSet resultSet = statement.executeQuery(sql);

            //5|遍历结果集
            /**
             *  最开始指针在第一行之前
             *  next() 判断是否有下一行，如果有下一行，将指针下移一位
             *
             */
            while (resultSet.next()){
                /**
                 * 通过列的索引获取列数据，索引从1开始
                 *
                 */
                int id = resultSet.getInt(1);
                int time1 = resultSet.getInt(2);
                int time2 = resultSet.getInt(3);

                System.out.println(id+"\t"+time1+"\t"+time2);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //6、回收资源
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection!=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
