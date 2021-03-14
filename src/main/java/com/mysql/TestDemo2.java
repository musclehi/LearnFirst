package com.mysql;

import java.sql.*;

public class TestDemo2 {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:com.mysql://localhost:3306/Future_Demo";
            String user = "root";
            String pass = "root";
            conn = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        Connection conn = getConnection();
        String sql = "select * from user2 where id = 1";
        PreparedStatement stmt;
        try {
            stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.next();
            ResultSetMetaData resultSetMetaData = rs.getMetaData();

            int count = resultSetMetaData.getColumnCount();
            String theSql = "insert into "+resultSetMetaData.getTableName(1)+" values(";
            for(int i = 1;i<= count ;i++){
                int type = resultSetMetaData.getColumnType(i);
                //字符串和时间类型
                if(type == 1 || type == -1 || type == 12|| type == 91|| type == 92|| type == 93){
                    theSql += ("'"+rs.getString(i)+"',");
                }
                else {
                    theSql += (rs.getString(i)+",");
                }
            }
            //替换掉空字符串
            theSql = theSql.replaceAll("'null'","null").replaceAll("'NULL'","null");
            theSql = theSql.substring(0,theSql.length()-1)+");";


        System.out.println(theSql);


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}