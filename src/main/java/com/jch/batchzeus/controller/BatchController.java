package com.jch.batchzeus.controller;

import com.alibaba.excel.EasyExcel;
import com.jch.batchzeus.listener.AddDecisionReasonParamsListener;
import com.jch.batchzeus.listener.AddFactorParamListener;
import com.jch.batchzeus.listener.AddParameterParamsListener;
import com.jch.batchzeus.listener.AddRuleParamListener;
import com.jch.batchzeus.param.AddDecisionReasonParams;
import com.jch.batchzeus.param.AddFactorParams;
import com.jch.batchzeus.param.AddParameterParams;
import com.jch.batchzeus.param.AddRuleParam;
import com.jch.batchzeus.utils.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/26 11:12 上午
 */
@Controller
public class BatchController {
    @Value("${zeus.address}")
    private String zeus_url;

    // 上传文件会自动绑定到MultipartFile中
    @PostMapping(value = "/upload")
    public String upload(HttpServletRequest request,
                         @RequestParam("type") String type,
                         @RequestParam("file") MultipartFile file, Model model) throws Exception {
        try {
            if (!file.isEmpty()) {
                if ("rule".equals(type)) {
                    addRule(file);
                } else if ("factor".equals(type)) {
                    addFactor(file);
                } else if ("param".equals(type)) {
                    addRuleParam(file);
                } else if ("reason".equals(type)) {
                    addDecisionReason(file);
                }
                return "success";
            } else {
                return "error";
            }
        } catch (Exception ex) {
            model.addAttribute("reason", ex.getMessage());
            return "error";
        }
    }

    @GetMapping("/download")
    public void download(HttpServletResponse response, @RequestParam("type") String type) throws IOException {
        String path = BatchController.class.getResource("/").getPath() + "file" + File.separator + type + ".xlsx";
        FileUtils.downloadExcel(response, path);
    }

    /**
     * 添加规则
     */
    public void addRule(MultipartFile file) throws Exception {
        AddRuleParamListener addRuleParamListener = new AddRuleParamListener(zeus_url);
        EasyExcel.read(file.getInputStream(), AddRuleParam.class, addRuleParamListener).sheet().doRead();
        if (addRuleParamListener.getErrorMsg() != null) {
            throw new Exception(addRuleParamListener.getErrorMsg());
        }
    }

    /**
     * 添加因子
     */
    public void addFactor(MultipartFile file) throws Exception {
        AddFactorParamListener addFactorParamListener = new AddFactorParamListener(zeus_url);
        EasyExcel.read(file.getInputStream(), AddFactorParams.class, addFactorParamListener).sheet().doRead();
        if (addFactorParamListener.getErrorMsg() != null) {
            throw new Exception(addFactorParamListener.getErrorMsg());
        }

    }

    /**
     * 添加参数
     */
    public void addRuleParam(MultipartFile file) throws Exception {
        AddParameterParamsListener addParameterParamsListener = new AddParameterParamsListener(zeus_url);
        EasyExcel.read(file.getInputStream(), AddParameterParams.class, addParameterParamsListener).sheet().doRead();
        if (addParameterParamsListener.getErrorMsg() != null) {
            throw new Exception(addParameterParamsListener.getErrorMsg());
        }
    }

    /**
     * 决策理由
     */
    public void addDecisionReason(MultipartFile file) throws Exception {
        AddDecisionReasonParamsListener addDecisionReasonParamsListener = new AddDecisionReasonParamsListener(zeus_url);
        EasyExcel.read(file.getInputStream(), AddDecisionReasonParams.class, addDecisionReasonParamsListener).sheet()
                 .doRead();
        if (addDecisionReasonParamsListener.getErrorMsg() != null) {
            throw new Exception(addDecisionReasonParamsListener.getErrorMsg());
        }
    }


}
