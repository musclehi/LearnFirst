package com.生产消费.blockqueue;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;

public class IdProvider implements Callable<Long> {

    BlockingQueue<List<Long>> queue;
    Long range = 10L;

    public IdProvider(BlockingQueue<List<Long>> queue) {
        this.queue = queue;
    }

    //    @Override
    public Long call() throws Exception {
        // 生产馒头
        Long maxId = 102L;
        Long total =Math.round(Math.ceil(maxId.doubleValue()/range.doubleValue()));
        for (Long i = 1L; i <= total; i++) {

            Long lowId = (i - 1L) * range + 1;
            Long highId = i * range;
            List<Long> ids = getIds(lowId, highId);
            try {
                Thread.sleep(100);
                if(ids.size() != 0) {
                    queue.put(ids);
                }
//                System.out.println("生产ID： " + ids);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        List<Long> msg = new ArrayList<Long>();
        try {
            msg.add(-1L);
//            msg.add(667L);
            queue.put(msg);
            System.out.println("put");
            return 0L;
        } catch (Exception e) {
            e.printStackTrace();
            return 0L;
        }
    }

    public Long getMaxId() throws Exception {
        Long id = 0L;
        Connection conn = null;
        String sql;
        String url = "jdbc:com.mysql://" + "localhost" + ":" + 3306 + "/" + "Future_Demo" + "?"
                + "user=root&password=root";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "SELECT id FROM  user ORDER BY id DESC limit 1";
            ResultSet result = stmt.executeQuery(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != null) {
                if (result.next()) {
                    id = result.getLong(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return id;
    }

    public List<Long> getIds(Long lowId, Long highId) throws Exception {
        List<Long> ids = new ArrayList<Long>();
        Connection conn = null;
        String sql;
        String url = "jdbc:com.mysql://" + "localhost" + ":" + 3306 + "/" + "Future_Demo" + "?"
                + "user=root&password=root";
        try {
            Class.forName("com.mysql.jdbc.Driver");// 动态加载mysql驱动
            conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            sql = "select id from user where id >= " + lowId + " and id <= " + highId;
            ResultSet result = stmt.executeQuery(sql);// executeUpdate语句会返回一个受影响的行数，如果返回-1就没有成功
            if (result != null) {
                while (result.next()) {
                    ids.add(result.getLong(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            conn.close();
        }
        return ids;
    }

}