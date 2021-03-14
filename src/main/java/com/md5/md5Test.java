package com.md5;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

public class md5Test {
    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String str = "apple";
        try {
            String newString = Md5.EncoderByMd5(str);
            System.out.println(newString);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(Md5.EncoderByMd5("apple").equals("HzhwvidPbEmz4xoMZyiVfw=="));
        System.out.println(Md5.checkpassword("apple","HzhwvidPbEmz4xoMZyiVfw=="));
        System.out.println(Md5.checkpassword("HzhwvidPbEmz4xoMZyiVfw==","apple"));

    }
}
