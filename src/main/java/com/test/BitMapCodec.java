package com.test;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BitMapCodec {

    public static final int BITMAP_BYTE_LEN = 500;

    private static void _printList(List<Long> list) {
        StringBuilder builder = new StringBuilder();
        for(Long val: list) {
            if(builder.length() > 0) {
                builder.append(" ");
            }
            builder.append(val);
        }
        System.out.println(builder.toString());
    }
    private static List<Long> _parse(long base, byte b){
        List<Long> resultList = new ArrayList<Long>();
        int byteVal = 128;
        for (int k = 0; k < 8;k++) {

            if( (byteVal & b) > 0) {
                resultList.add(base);
            }
            base++;
            byteVal = byteVal >> 1;
        }
        return resultList;
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

    public static List<Long> parse(long base, String bitmap){
        List<Long> resultList = new ArrayList<Long>();
        if(StringUtils.isBlank(bitmap)) {
            return null;
        }
        byte[] bytes= Base64.decodeBase64(bitmap);
        if(bytes.length > BITMAP_BYTE_LEN) {
            return null;
        }else {
            for(byte b: bytes) {
                resultList.addAll(_parse(base, b));
                base += 8;
            }
            return resultList;
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

    public static void main(String[] args) {

        int test = 100;
        long base = 1000;
        for(int i = 20; i< 35; i++) {
            if(Math.random() < 0.37) {
                base += Long.MAX_VALUE >> i;
            }
        }
        System.out.println("com.base: " + base);
//        while(ABtest >= 0) {
            List<Long> testList = new ArrayList<Long>();
            for(int i = 0; i < 32; i++) {
                if(Math.random() < 0.4) {
                    testList.add( base + i);
                }
            }
            _printList(testList);
            String encoded = encode(base, testList);
            System.out.println(encoded);
            List<Long> decodeList = parse(base, encoded);
            _printList(decodeList);
            if(null == decodeList || decodeList.size() != decodeList.size()) {
                System.out.println(false);
            }else {
                for(int i = 0; i< testList.size();i++) {
                    if(testList.get(i).longValue() != decodeList.get(i).longValue()) {
                        System.out.println(false);
                        break;
                    }else {
                        continue;
                    }
                }
                System.out.println(true);
            }
            test--;
//        }
    }
}
