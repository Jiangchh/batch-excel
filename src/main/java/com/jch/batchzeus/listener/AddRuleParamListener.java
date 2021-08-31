package com.jch.batchzeus.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.jch.batchzeus.HttpResult;
import com.jch.batchzeus.param.AddRuleParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/26 2:16 下午
 */
public class AddRuleParamListener extends AnalysisEventListener<AddRuleParam> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AddRuleParamListener.class);
    RestTemplate restTemplate = new RestTemplate();
    private String url;
    private String errorMsg = null;

    public AddRuleParamListener(String url) {
        this.url = url + "/rule/add";
    }

    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data    one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(AddRuleParam data, AnalysisContext context) {
        data.setEditMode(0);
        data.setBusinesses("1");
        data.setUserName("admin");
        saveData(data);

    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData(AddRuleParam data) {
        try {
            HttpResult httpResult = restTemplate.postForObject(url, data, HttpResult.class);
            if (!HttpResult.SUCCESS.equals(httpResult.getDesc())) {
                LOGGER.warn("{}插入异常,原因:{}", data.getAlias(), httpResult.getDesc());
                errorMsg = httpResult.getDesc();
            }
        } catch (Exception ex) {
            errorMsg = ex.getMessage();
            LOGGER.error("新增规则异常:{}", data.getAlias(), ex);
        }
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
