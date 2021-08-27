package com.jch.batchzeus;

import java.io.Serializable;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/26 3:56 下午
 */
public class HttpResult implements Serializable {

    public static final Integer ExceptionCode = 2;
    public static final String EMPTY_REQUEST_ID = "0";
    public static final String SUCCESS = "success";
    protected String requestId;
    protected Integer code;
    protected String desc;
    protected Object data;
    protected Long executeTime;

    public HttpResult() {
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Long getExecuteTime() {
        return this.executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public String getRequestId() {
        return this.requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.requestId + "," + this.code + "," + this.desc + "," + this.data + "," + this.executeTime;
    }

}
