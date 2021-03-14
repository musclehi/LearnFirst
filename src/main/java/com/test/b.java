package com.test;


//import org.apache.commons.beanutils.BeanUtils;

import com.base.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class b {

    static int total = 0;

    public static void main(String args[]) throws Exception {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse("2020-08-07");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        long timestamp = cal.getTimeInMillis();
        System.out.println(timestamp);
    }

}
