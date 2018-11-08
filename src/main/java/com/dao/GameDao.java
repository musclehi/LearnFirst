package com.dao;

import com.entity.Game;
import com.util.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GameDao {

    public int addGame(Game game) {
        Connection conn = DBConnect.getConn();

        String sql = "insert into game (type,icon,name,developer,state,autoupdate,isofficial,operatetime,dateissued,updatetime,activecomment,downloadnum) " +
                "values(?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pstmt;
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, game.getType());
            pstmt.setString(2, game.getIcon());
            pstmt.setString(3, game.getName());
            pstmt.setString(4, game.getDeveloper());
            pstmt.setInt(5, game.getState());
            pstmt.setInt(6, game.getAutoUpdate());
            pstmt.setInt(7, game.getIsOfficial());
            pstmt.setDate(8, new Date(game.getOperateTime().getTime()));
            pstmt.setDate(9, new Date(game.getDateIssued().getTime()));
            pstmt.setDate(10, new Date(game.getUpdateTime().getTime()));
            pstmt.setInt(11, game.getActiveComment());
            pstmt.setInt(12, game.getDownloadNum());
            int i = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return i;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List gameList() {
        Connection conn = DBConnect.getConn();

        String sql = "SELECT * FROM game";
//        String sql = "select count(*) from user";
        Statement stmt;
        ResultSet res = null;
        ArrayList<Game> list = new ArrayList<Game>();
        try {
            stmt = conn.createStatement();
            res = stmt.executeQuery(sql);
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                Game game = new Game();
                game.setType(res.getInt("type"));
                game.setIcon(res.getString("icon"));
                game.setName(res.getString("name"));
                game.setDeveloper(res.getString("developer"));
                game.setState(res.getInt("state"));
                game.setAutoUpdate(res.getInt("autoupdate"));
                game.setIsOfficial(res.getInt("isofficial"));
                game.setOperateTime(res.getTimestamp("operatetime"));
                game.setDateIssued(res.getTimestamp("dateissued"));
                game.setUpdateTime(res.getTimestamp("updatetime"));
                game.setActiveComment(res.getInt("activecomment"));
                game.setDownloadNum(res.getInt("downloadnum"));
                list.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public List gameList(int page) {
        Connection conn = DBConnect.getConn();

        String sql = "SELECT * FROM game limit ?,?";
        PreparedStatement pstmt;
        ResultSet res = null;
        ArrayList<Game> list = new ArrayList<Game>();
        try {
            pstmt = (PreparedStatement) conn.prepareStatement(sql);
            pstmt.setInt(1, 10*(page-1));
            pstmt.setInt(2, 10);
            System.out.println(pstmt);
            res = pstmt.executeQuery();
            while (res.next()) {
                //建立了一个实体类,用来存放从数据库中拿到的数据
                Game game = new Game();
                game.setId(res.getInt("id"));
                game.setType(res.getInt("type"));
                game.setIcon(res.getString("icon"));
                game.setName(res.getString("name"));
                game.setDeveloper(res.getString("developer"));
                game.setState(res.getInt("state"));
                game.setAutoUpdate(res.getInt("autoupdate"));
                game.setIsOfficial(res.getInt("isofficial"));
                game.setOperateTime(res.getTimestamp("operatetime"));
                game.setDateIssued(res.getTimestamp("dateissued"));
                game.setUpdateTime(res.getTimestamp("updatetime"));
                game.setActiveComment(res.getInt("activecomment"));
                game.setDownloadNum(res.getInt("downloadnum"));
                list.add(game);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }
}
