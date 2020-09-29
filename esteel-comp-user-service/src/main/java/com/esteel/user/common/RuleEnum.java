package com.esteel.user.common;

/**
 * @author liujie
 * @version 1.0.0
 * @ClassName RuleEnum.java
 * @Description TODO
 * @createTime 2020年5月12日 10:23
 */
public enum RuleEnum {

    /**
     * 自动分配
     */
    AUTO("AUTO", "自动分配"),
    /**
     * 自动分配
     */
    MANUAL("MANUAL", "手动分配");

    private String code;
    private String msg;

    RuleEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
