package com.jch.batchzeus.param;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;

public class AddRuleParam extends BaseParam {
    @ExcelProperty(value = "规则唯一名")
    private String name;
    @ExcelProperty(value = "规则备注")
    private String alias;
    @ExcelProperty(value = "规则内容")
    private String expression;
    @ExcelIgnore
    private String businesses;
    @ExcelIgnore
    private Integer subBusiness;
    @ExcelIgnore
    private Integer editMode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }


    public String getBusinesses() {
        return businesses;
    }

    public void setBusinesses(String businesses) {
        this.businesses = businesses;
    }


    public Integer getSubBusiness() {
        return subBusiness;
    }

    public void setSubBusiness(Integer subBusiness) {
        this.subBusiness = subBusiness;
    }

    public Integer getEditMode() {
        return editMode;
    }

    public void setEditMode(Integer editMode) {
        this.editMode = editMode;
    }


}
