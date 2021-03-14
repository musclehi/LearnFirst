package com.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import java.util.Collection;
import java.util.Set;


public class TableDemo {

//    两个健一个值，类似于三维的表
    public static void main(String args[]) {
        Table<String, String, Integer> tables = HashBasedTable.create();
        tables.put("a", "javase", 80);
        tables.put("b", "javaee", 90);
        tables.put("c", "javame", 100);
        tables.put("d", "com/guava", 70);

        Set<Table.Cell<String,String,Integer>> cells=tables.cellSet();
        for(Table.Cell<String,String,Integer> temp:cells){
            System.out.println(temp.getRowKey()+" "+temp.getColumnKey()+" "+temp.getValue());
        }


        Set<String> students=tables.rowKeySet();
        System.out.println("rowKeySet:");
        for(String str:students){
            System.out.println(str);
        }

        Set<String> courses=tables.columnKeySet();
        System.out.println("columnKeySet:");
        for(String str:courses){
            System.out.println(str);
        }

        System.out.println("values:");
        Collection<Integer> scores=tables.values();
        for(Integer in:scores){
            System.out.println(in);
        }


    }
}

