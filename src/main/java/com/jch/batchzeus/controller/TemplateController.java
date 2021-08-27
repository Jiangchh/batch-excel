package com.jch.batchzeus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: jiangchenghua
 * @Date: 2021/8/26 5:15 下午
 */
@Controller
public class TemplateController {
    @RequestMapping("/")
    public String index() {
        // 根据Thymeleaf默认模板，将返回resources/templates/index.html
        return "index";
    }
}
