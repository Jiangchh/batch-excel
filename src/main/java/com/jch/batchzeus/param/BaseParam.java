package com.jch.batchzeus.param;

/*
 * 请求参数基础类
 */
abstract public class BaseParam {

    private static final String PHP_TRUE_VALUE = "1";
    private static final String PHP_FALSE_VALUE = "0";
    protected Integer businessCode;
    protected String userName;

    public Integer getBusinessCode() {
        return businessCode;
    }

    public void setBusinessCode(Integer businessCode) {
        this.businessCode = businessCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
