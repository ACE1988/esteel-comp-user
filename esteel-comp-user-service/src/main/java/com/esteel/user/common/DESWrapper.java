package com.esteel.user.common;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;

/**
 * @version 1.0.0
 * @ClassName DESWrapper.java
 * @author: liu Jie
 * @Description: 加解密
 * @createTime: 2020年-10月-12日  16:07
 */
public class DESWrapper {

    private  static  final  String CARD_NO_KEY = "onDZWwQ35ieE3N/4AuSATjB3AibsnWRi";

    public static String encrypt(String src){
        return encrypt(src, CARD_NO_KEY);
    }

    /**
     * 加密
     * @param src
     * @param key
     * @return
     */
    public static String encrypt(String src, String key) {
        if(StringUtils.isBlank(src) || StringUtils.isBlank(key)){
            return  null;
        }
        String result;
        try {
            byte[] data = DesUtil.encrypt(src.getBytes("UTF-8"), Base64.decodeBase64(key));
            result = Base64.encodeBase64String(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public static String decrypt(String src){
        return decrypt(src,CARD_NO_KEY);
    }

    /**
     * 解密
     * @param src
     * @param key
     * @return
     */
    public static String decrypt(String src, String key) {
        if(StringUtils.isBlank(src) || StringUtils.isBlank(key)){
            return  null;
        }
        String result;
        try {
            byte[] data = DesUtil.decrypt(Base64.decodeBase64(src), Base64.decodeBase64(key));
            result = new String(data, "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String genKey() {
        String result;
        try {
            byte[] data = DesUtil.initKey();
            result = Base64.encodeBase64String(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

}
