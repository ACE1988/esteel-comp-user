package com.esteel.user.common;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName DesUtil.java
 * @Description TODO
 * @createTime 2020年5月20日 14:27
 */
public abstract  class AbstractDesUtil {

    /**
     * 密钥算法
     * @version 1.0
     * @author
     */
    public static final String KEY_ALGORITHM = "DESede";

    /**
     * 加密/解密算法/工作模式/填充方式
     * @version 1.0
     * @author
     */
    public static final String CIPHER_ALGORITHM = "DESede/ECB/PKCS5Padding";

    /**
     * 转换密钥
     * @param key 二进制密钥
     * @return key 密钥
     *
     */
    public static Key toKey(byte[] key) throws Exception{
        //实例化DES密钥材料
        DESedeKeySpec dks = new DESedeKeySpec(key);
        //实例化秘密密钥工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(KEY_ALGORITHM);
        //生成秘密密钥
        return keyFactory.generateSecret(dks);
    }

    /**
     * 解密
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密数据
     */
    public static byte[] decrypt(byte[] data, byte[] key)throws Exception{
        //还原密钥
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance(CIPHER_ALGORITHM);
        //初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, k);
        //执行操作
        return cipher.doFinal(data);
    }

    public static byte[] encrypt(byte[] data, byte[] key) throws Exception{
        //还原密钥
        Key k = toKey(key);
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        //初始化，设置为解密模式
        cipher.init(Cipher.ENCRYPT_MODE,  k);

        //执行操作
        return cipher.doFinal(data);
    }


    @SuppressWarnings("unused")
    private static SecureRandom algorithmParameterSpec(int i, int j, int k,
                                                       int l, int m, int n, int o, int p) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * 生成密钥
     *
     * @return byte[] 二进制密钥
     */
    public static byte[] initKey() throws Exception{
        KeyGenerator kg = KeyGenerator.getInstance(KEY_ALGORITHM);
        kg.init(168);
        //生成秘密密钥
        SecretKey secretKey = kg.generateKey();
        //获得密钥的二进制编码形式
        return secretKey.getEncoded();
    }



    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

//	   BASE64Decoder dec=new BASE64Decoder();
//	   BASE64Encoder enc = new BASE64Encoder();
//        String ming = "123456";
//        byte[] s = AbstractDesUtil.encrypt(ming.getBytes("UTF-8"), "955e43afa6dcb571acec7328e3b36ca6".getBytes("UTF-8"));
    }

    /**10进制数组转换16进制数组*/
    public static String printbytes(String tip, byte[] b) {
        String ret = "";
        String str;
        System.out.print(tip);
        for (int i = 0; i < b.length; i++) {

            str = Integer.toHexString((int) (b[i] & 0xff));

            if (str.length() == 1){
                str = "0" + str;
            }
            ret = ret + str + " ";
        }
        System.out.println();

        // 02 00 07 00 00 60 70 01 17 35 03 C8
        return ret;
    }

}