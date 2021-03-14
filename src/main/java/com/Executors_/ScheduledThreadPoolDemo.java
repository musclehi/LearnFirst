package com.Executors_;

import org.apache.commons.codec.binary.Base64;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScheduledThreadPoolDemo {

    public static final int BITMAP_BYTE_LEN = 500;

    public static void main(String[] args) {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2l);
        ids.add(3l);
        String ss = encode(4000,ids);
        System.out.println(ss);

    }

    private static byte _byte(int val) {
        val = val & 255;
        if(val < 128) {
            return (byte)val;
        }else {
            val  = val - 256;
            return (byte)val;
        }
    }

    public static String encode(long base, List<Long> idList) {
        if(null == idList || idList.size() == 0 || idList.size() > BITMAP_BYTE_LEN * 8) {
            return null;
        }

        List<Byte> byteList = new ArrayList<Byte>();
        Collections.sort(idList);

        int index = 0, len = idList.size();
        long start = base;
        int byteVal = 0;
        StringBuilder builder = new StringBuilder();
        while(index < len && start < (base + BITMAP_BYTE_LEN * 8)) {
            long num = idList.get(index);
            byteVal  = byteVal << 1;
            if(num == start) {
                byteVal += 1;
                index++;
                builder.append("1");
            }else if(num < start){
                index++;
                // escape equal numbers
                while( index < len) {
                    if(idList.get(index) == num) {
                        index++;
                    }else {
                        break;
                    }
                }
            }else {
                builder.append("0");
            }
            if(start != base && (start- base +1) % 8 == 0) {
                byteList.add(_byte(byteVal));
                byteVal = 0;
            }
            start++;
        }

        int left = (int)((start - base) % 8);
        for(int i= left;i< 8 ;i++) {
            byteVal  = byteVal << 1;
            builder.append("0");
        }
        if(left != 0) {
            byteList.add(_byte(byteVal));
        }
        byte[] bytes = new byte[byteList.size()];
        for(int i = 0; i< byteList.size();i++) {
            bytes[i] = byteList.get(i);
        }
        return Base64.encodeBase64String(bytes);
    }
}
