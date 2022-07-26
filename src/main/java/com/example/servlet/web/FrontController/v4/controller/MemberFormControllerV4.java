package com.example.servlet.web.FrontController.v4.controller;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.v3.ControllerV3;
import com.example.servlet.web.FrontController.v4.ControllerV4;

import java.util.Map;

public class MemberFormControllerV4 implements ControllerV4 {

    @Override
    public String process(Map<String, String> paramMap, Map<String, Object> model) {
        return "new-form";
    }
}
