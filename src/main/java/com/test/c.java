package com.test;


public class c {


    public static void main(String[] args) throws Exception {
        String toDbName = "joint_subaccount";
        String toTableName = "t_game_sub_account";
        for (int key = 0; key < 1024; key++) {

            toDbName = "joint_subaccount";
            toTableName = "t_game_sub_account";
            int confirmDb = ((key % 1024) / 32);
            if (confirmDb < 10) toDbName += "_00" + confirmDb;
            else if (confirmDb < 100) toDbName += "_0" + confirmDb;
            if (key % 32 == 0) {
                System.out.println("use " + toDbName + ";");
            }
            //表名
            int confirmTable = (key % 1024);
            if (confirmTable < 10) toTableName += "_000" + confirmTable;
            else if (confirmTable < 100) toTableName += "_00" + confirmTable;
            else if (confirmTable < 1000) toTableName += "_0" + confirmTable;
            else toTableName += "_" + confirmTable;

            System.out.println("alter table "+toTableName+" drop index t_sub_account_unique_uuid;");
            System.out.println("alter table "+toTableName+" drop index t_userid_packname_nickname;");
            System.out.println("alter table "+toTableName+" drop index t_sub_account_unique_openid_gamepackage;");



        }


    }


}



