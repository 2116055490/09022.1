package edu.xcdq;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        Statement statement = null;
        try{
             // 1 加载驱动
             Class.forName("com.mysql.jdbc.Driver");
             // 2 获取连接
             String url = "jdbc:mysql://localhost:3306/test01 useUnicode=true&characterEncoding=utf8";
             conn = DriverManager.getConnection(url, "root", "905274");
             // 3 编写SQL语句
             String sql = "insert into book values('5','钢铁是怎样炼成的','奥斯托洛夫斯基',30)";
             // 4 创建statement对象
             statement = conn.createStatement();
             int rows = statement.executeUpdate(sql);
             if (rows>0){
                 System.out.println("添加成功");
             }else{
                 System.out.println("添加失败");
             }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            // 5 释放资源
            try{
                if (statement != null){
                    statement.close();
                }
                if (conn != null){
                    conn.close();
                }
            }catch (Exception e2){
                e2.printStackTrace();
            }
        }
    }
}
