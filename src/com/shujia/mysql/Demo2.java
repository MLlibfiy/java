package com.shujia.mysql;

import java.sql.*;

/**
 * 查询每个学生的总分
 * 结果（学号，学生名，性别，年龄，班级，总分）
 */
public class Demo2 {
    public static void main(String[] args) {

        Connection root = null;
        Statement statement = null;
        try {
            //加载驱动，将Driverclass文件加载到内存
            Class.forName("com.mysql.jdbc.Driver");

            //建立数据库连接
            root = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");

            //获取sql执行器
            statement = root.createStatement();

            String sql = "select a.id,a.name,a.age,a.clazz,sum(b.score) as sumscore from student as a join score as b on a.id=b.student_id group by a.id,a.name,a.age,a.clazz";

            //执行sql 返回结果
            ResultSet resultSet = statement.executeQuery(sql);

            //一行一行获取
            while (resultSet.next()) {
                //通过列名获取数据
                String id = resultSet.getString("id");
                //通过下表获取数据
                String name = resultSet.getString(2);
                String age = resultSet.getString("age");
                String clazz = resultSet.getString("clazz");
                String sumscore = resultSet.getString("sumscore");

                System.out.println(id + "," + name + "," + age + "," + clazz + "," + sumscore);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

            //6、回收资源
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (root != null) {
                try {
                    root.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}
