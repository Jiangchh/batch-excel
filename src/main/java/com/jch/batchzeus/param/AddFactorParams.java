package com.jch.batchzeus.param;

import com.alibaba.excel.annotation.ExcelProperty;
import com.google.common.base.Objects;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/27 10:28 上午
 */
public class AddFactorParams extends BaseParam {

    @ExcelProperty(value = "名称")
    private String name;
    @ExcelProperty(value = "备注")
    private String alias;
    @ExcelProperty(value = "结果类型")
    private String resultDesc;
    @ExcelProperty(value = "表达式")
    private String expression;
    /**
     * 1:普通,2：累计,4：决策
     */
    private Integer type;
    private Integer resultType;
    private String businesses;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getResultType() {
        return resultType;
    }

    public void setResultType(Integer resultType) {
        this.resultType = resultType;
    }

    public String getResultDesc() {
        return resultDesc;
    }

    public void setResultDesc(String resultDesc) {
        this.resultDesc = resultDesc;
    }

    public String getBusinesses() {
        return businesses;
    }

    public void setBusinesses(String businesses) {
        this.businesses = businesses;
    }


    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                      .add("name", name)
                      .add("alias", alias)
                      .add("expression", expression)
                      .add("type", type)
                      .add("resultType", resultType)
                      .add("userName", userName)
                      .add("businesses", businesses)
                      .toString();
    }


}
