package com.ougen.jiami_write;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author:ougen
 * @date:2018/9/815:49
 */
public class ShaUtil {
    public static String getSha(String s){
        try {
            String salt = Salt.getSalt();
            System.out.println(salt);
            MessageDigest messageDigest = MessageDigest.getInstance("sha-1");
            byte[] news = messageDigest.digest((s+salt).getBytes());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : news){
                stringBuffer.append(Integer.toHexString(b));
            }
            return stringBuffer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
