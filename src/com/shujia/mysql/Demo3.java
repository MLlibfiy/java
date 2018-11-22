package com.shujia.mysql;

import java.sql.*;

public class Demo3 {
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


            //插入数据，返回值是受影响的行数
            int i = statement.executeUpdate("insert into user values(1,1),(2,2)");

            if (i > 0) {
                System.out.println("插入成功");
            }

            //更新数据，返回值是受影响的行数
            int i1 = statement.executeUpdate("update user set name='张三' where id=1");

            if (i1 > 0) {
                System.out.println("更新成功");
            }

            //删除数据，返回值是受影响的行数
            int i2 = statement.executeUpdate("delete from user where id='1'");
            if (i2 > 0) {
                System.out.println("删除成功");
            }

            //查询数据
            ResultSet resultSet = statement.executeQuery("select * from user");

            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);

                System.out.println(id+"\t"+name);
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
