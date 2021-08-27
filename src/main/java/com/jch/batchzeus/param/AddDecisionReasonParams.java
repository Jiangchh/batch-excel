package com.jch.batchzeus.param;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/27 8:08 下午
 */
public class AddDecisionReasonParams extends BaseParam {
    @ExcelProperty(value = "决策理由")
    private String reason;
    @ExcelProperty(value = "code")
    private String code;
    private Integer priority;
    private String businesses;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getBusinesses() {
        return businesses;
    }

    public void setBusinesses(String businesses) {
        this.businesses = businesses;
    }

}
