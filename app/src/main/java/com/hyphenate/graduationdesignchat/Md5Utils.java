package com.hyphenate.graduationdesignchat;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Scus on 2018/3/16.
 */

public class Md5Utils {

    public static String md5Password(String password) {
        StringBuffer stringBuffer = new StringBuffer();

        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] digest = messageDigest.digest(password.getBytes());
            //每个byte做一个与运算
            for (Byte b : digest) {
                int i = b & 0xff;
                String hexString = Integer.toHexString(i);
                if (hexString.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(hexString);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }
}
