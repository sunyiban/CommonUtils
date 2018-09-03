package com.util.encode;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * @author sunyiban
 * @version V 1.0
 * @Title AESCode -> Class
 * @Package CommonUtils -> com.util.encode
 * @Description AES加/解密
 * @date 2018/9/3 9:53
 */
public class AESCode {

    /**
     * 加密
     *
     * @param key
     * @param data
     * @return java.lang.String
     */
    public static byte[] encrypt(String key, String data) {
        try {
            // 创建AES的key生产者
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            // 利用用户key作为随机数初始化
            keyGenerator.init(128, new SecureRandom(key.getBytes()));
            // 生成一个密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 返回基本编码格式的密钥，如果此密钥不支持编码，则返回NULL
            byte[] enCodeFormat = secretKey.getEncoded();
            // 转换为AES专用密钥
            SecretKeySpec aesKey = new SecretKeySpec(enCodeFormat, "AES");
            // 创建密码器
            Cipher cipher = Cipher.getInstance("AES");
            byte[] byteContent = data.getBytes("utf-8");
            // 初始化为加密模式的密码器
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            // 加密
            byte[] result = cipher.doFinal(byteContent);
            return result;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     *
     * @param key
     * @param data
     * @return java.lang.String
     */
    public static String decrypt(String key, byte[] data) {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(128, new SecureRandom(key.getBytes()));
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] enCodeFormat = secretKey.getEncoded();
            SecretKeySpec aesKey = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, aesKey);
            byte[] result = cipher.doFinal(data);
            return new String(result);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        /*String word = "你好啊，告诉你一个秘密";
        byte[] encrypt = encrypt("sun", word);
        System.out.println("加密后：");
        System.out.println(new String(encrypt));

        for (byte a : encrypt) {
            System.out.println(a);
        }

        String decrypt = decrypt("sun", encrypt);
        System.out.println("解密后：" + decrypt);*/

        byte[] b = new byte[]{11,23,-17,-65,-67,37,20};
        String a = new String(b);
        System.out.println(a);

        System.out.println("===============================");
        for(byte c : a.getBytes()) {
            System.out.print(c + ",");
        }
    }

}
