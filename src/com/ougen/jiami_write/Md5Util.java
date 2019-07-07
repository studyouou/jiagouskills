package com.ougen.jiami_write;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author:ougen
 * @date:2018/9/815:09
 */
public class Md5Util {
    public static String md5(String string) {
        try {
            String salt = "sa5462439w9-2373.1r6a42349*32-4@$@%#$%#$?~!@/*/hs$TRGs";
            String newString = string+salt;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] newByte = messageDigest.digest(newString.getBytes("utf-8"));
            String newMessage = new String(newByte);
            System.out.println(newMessage);
            BASE64Encoder base64Encoder = new BASE64Encoder();
            String base64Message = base64Encoder.encode(newMessage.getBytes());
            System.out.println(base64Message);
            BASE64Decoder base64Decoder = new BASE64Decoder();
            String old = new String(base64Decoder.decodeBuffer(base64Message));
            System.out.println(old);
            if (old.equals(newMessage)){
                return base64Message;
            }
            throw new RuntimeException("buzhiyi");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static byte[] get(){
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            return  messageDigest.digest("sa5462439w9-2373.1r6a42349*32-4@$@%#$%#$?~!@/*/hs$TRGs".getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
}
