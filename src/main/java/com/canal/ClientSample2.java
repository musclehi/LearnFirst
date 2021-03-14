package com.canal;


import com.alibaba.otter.canal.client.CanalConnector;
import com.alibaba.otter.canal.client.CanalConnectors;
import com.alibaba.otter.canal.protocol.CanalEntry.*;
import com.alibaba.otter.canal.protocol.Message;
import org.apache.commons.lang.StringUtils;

import java.net.InetSocketAddress;
import java.util.List;


public class ClientSample2 {

    public static void main(String args[]) throws Exception{

        CanalConnector connector = CanalConnectors.newSingleConnector(new InetSocketAddress("10.101.100.94",
                11111), "example", "", "");

        connector.connect();
        connector.subscribe("ABtest\\.user");
        connector.rollback();

        int batchSize = 5 * 1024;

        while (true) {
            Message message = connector.getWithoutAck(batchSize); // 获取指定数量的数据
            long batchId = message.getId();
            int size = message.getEntries().size();
            if (batchId == -1 || size == 0) {
                // try {
                // Thread.sleep(1000);
                // } catch (InterruptedException e) {
                // }
            } else {
//                       System.out.println(message.getEntries());

                synchronizedData(message.getEntries());
            }

            connector.ack(batchId); // 提交确认
            // connector.rollback(batchId); // 处理失败, 回滚数据
        }
    }

    /**
     * 同步数据
     *
     * @param entries
     * @throws Exception
     */
    private static void synchronizedData(List<Entry> entries) throws Exception {
        for (Entry entry : entries) {
            if (entry.getEntryType() != EntryType.ROWDATA) {
                continue;
            }
            RowChange rowChange = RowChange.parseFrom(entry.getStoreValue());
            String tableName = entry.getHeader().getTableName();
            for (RowData rowData : rowChange.getRowDatasList()) {
                String sql = getSql(rowChange.getEventType(), tableName, rowData);
                System.out.println(sql);
                // TODO 执行sql语句
            }
        }
    }


    /**
     * 获取增删改的sql
     *
     * @param eventType
     * @param tableName
     * @param rowData
     * @return
     */
    private static String getSql(EventType eventType, String tableName, RowData rowData) {
        String sql = null;
        switch (eventType) {
            case INSERT:
                sql = getInsertSql(tableName, rowData.getAfterColumnsList());
                break;
            case UPDATE:
                sql = getUpdateSql(tableName, rowData.getAfterColumnsList());
                break;
            case DELETE:
                sql = getDeleteSql(tableName, rowData.getBeforeColumnsList());
                break;
            default:
                break;
        }
        return sql;
    }

    private static String getInsertSql(String tableName, List<Column> columns) {
        if (columns.size() == 0 || StringUtils.isBlank(tableName)) {
            return null;
        }
        String keys = "";
        String values = "";
        for (int i = 0; i < columns.size(); i++) {
            if (i != 0) {
                keys += ",";
                values += ",";
            }
            keys += columns.get(i).getName();
            values += getValue(columns.get(i));
        }
        String format = "INSERT INTO %s (%s) VALUES (%s)";
        return String.format(format, tableName, keys, values);
    }



    private static String getUpdateSql(String tableName, List<Column> columns) {
        if (columns.size() == 0 || StringUtils.isBlank(tableName)) {
            return null;
        }
        String sets = "";
        String where = "";
        for (Column column : columns) {
            if (column.getIsKey()) {
                where = column.getName() + "=" + getValue(column);
                continue;
            }
            if (!StringUtils.isBlank(sets)) {
                sets += ",";
            }
            sets += column.getName() + "=" + getValue(column);
        }
        String format = "UPDATE %s SET %s WHERE %s";
        return String.format(format, tableName, sets, where);
    }


    private static String getDeleteSql(String tableName, List<Column> columns) {
        if (columns.size() == 0 || StringUtils.isBlank(tableName)) {
            return null;
        }
        String where = "";
        for (Column column : columns) {
            if (column.getIsKey()) {
                where = column.getName() + "=" + getValue(column);
                continue;
            }
        }
        String format = "DELETE FROM %s WHERE %s";
        return String.format(format, tableName, where);
    }


    private static String getValue(Column column) {
        if (column.getIsNull()) {
            return "null";
        }
        return String.format("'%s'", column.getValue());
    }




}
