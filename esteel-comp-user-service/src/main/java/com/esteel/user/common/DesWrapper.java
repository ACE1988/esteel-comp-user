//package com.smmf.approve.common;
//
//import com.smmf.approve.task.InitSystemVariable;
//import org.apache.commons.lang3.StringUtils;
//import sun.misc.BASE64Decoder;
//import sun.misc.BASE64Encoder;
//
///**
// * @author liujie
// * @version 1.0.0
// * @ClassName DESWrapper.java
// * @Description 加解密
// * @createTime 2020年5月20日 14:26
// */
//public class DesWrapper {
//
//    public static String encrypt(String src){
//        return encrypt(src, InitSystemVariable.CARD_NO_KEY);
//    }
//
//    /**
//     * 加密
//     * @paramsrc
//     * @param key
//     * @return
//     */
//    public static String encrypt(String src, String key) {
//        if(StringUtils.isBlank(src) || StringUtils.isBlank(key)){
//            return  null;
//        }
//        String result;
//        try {
//            byte[] data = AbstractDesUtil.encrypt(src.getBytes("UTF-8"), key.getBytes());
//            result = new BASE64Encoder().encode(data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//
//    public static String decrypt(String src){
//        return decrypt(src,InitSystemVariable.CARD_NO_KEY);
//    }
//
//    /**
//     * 解密
//     * @param src
//     * @param key
//     * @return
//     */
//    public static String decrypt(String src, String key) {
//        if(StringUtils.isBlank(src) || StringUtils.isBlank(key)){
//            return  null;
//        }
//        String result;
//        try {
//            byte[] data = AbstractDesUtil.decrypt(new BASE64Decoder().decodeBuffer(src), key.getBytes());
//            result = new String(data, "UTF-8");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//
//    public static String genKey() {
//        String result;
//        try {
//            byte[] data = AbstractDesUtil.initKey();
//            result = new BASE64Encoder().encode(data);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}
