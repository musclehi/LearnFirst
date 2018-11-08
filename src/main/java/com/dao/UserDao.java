package com.dao;

import com.entity.User;
import com.util.DBConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public int addUser(User user) {
        Connection conn = DBConnect.getConn();

        String sql = "insert into user (username,password) values(?,?)";
        PreparedStatement pstmt;
        try {
                pstmt = (PreparedStatement) conn.prepareStatement(sql);
                pstmt.setString(1, user.getUserName());
                pstmt.setString(2, user.getPassWord());
                int i = pstmt.executeUpdate();
                pstmt.close();
                conn.close();
                return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int findUser(User user) {
        Connection conn = DBConnect.getConn();

        String sql = "SELECT count(*) FROM user where username= ? and password = ?";
//        String sql = "select count(*) from user";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassWord());
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            pstmt.close();
            conn.close();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    public int findUserByUsername(String username) {
        Connection conn = DBConnect.getConn();

        String sql = "SELECT count(*) FROM user where username= ?";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int rows = rs.getInt(1);
            pstmt.close();
            conn.close();
            return rows;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
