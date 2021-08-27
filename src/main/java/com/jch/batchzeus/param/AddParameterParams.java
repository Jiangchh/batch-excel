package com.jch.batchzeus.param;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/27 6:04 下午
 */
public class AddParameterParams extends BaseParam {
    private static final int AUTO_GEN_FACTOR_TRUE = 1;
    @ExcelProperty(value = "名称")
    private String name;
    @ExcelProperty(value = "备注")
    private String description;
    @ExcelProperty(value = "结果类型")
    private String resultDesc;
    private Integer resultType;
    private String expression;
    private String paramList;
    private Integer autoGenFactor;
    private String factorName;
    private String factorAlias;
    private String businesses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpression() {
        return expression;
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

    public String getParamList() {
        return paramList;
    }

    public void setParamList(String paramList) {
        this.paramList = paramList;
    }

    public Integer getAutoGenFactor() {
        return autoGenFactor;
    }

    public void setAutoGenFactor(Integer autoGenFactor) {
        this.autoGenFactor = autoGenFactor;
    }

    public boolean needAutoGenFactor() {
        if (autoGenFactor != null) {
            return autoGenFactor == AUTO_GEN_FACTOR_TRUE;
        }
        return false;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getFactorName() {
        return factorName;
    }

    public void setFactorName(String factorName) {
        this.factorName = factorName;
    }

    public String getFactorAlias() {
        return factorAlias;
    }

    public void setFactorAlias(String factorAlias) {
        this.factorAlias = factorAlias;
    }


    public String getBusinesses() {
        return businesses;
    }

    public void setBusinesses(String businesses) {
        this.businesses = businesses;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(AddParameterParams.class)
                      .add("name", this.name)
                      .add("description", this.description)
                      .add("resultType", this.resultType)
                      .add("expression", this.expression)
                      .add("paramList", this.paramList)
                      .add("autoGenFactor", this.autoGenFactor)
                      .add("factorName", this.factorName)
                      .add("factorAlias", this.factorAlias)
                      .add("userName", this.userName)
                      .add("businesses", this.businesses)
                      .toString();
    }
}
