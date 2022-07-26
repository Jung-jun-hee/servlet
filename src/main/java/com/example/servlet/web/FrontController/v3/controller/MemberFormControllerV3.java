package com.example.servlet.web.FrontController.v3.controller;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {

    @Override
    public ModelView process(Map<String, String> paramMap) {
        return new ModelView("new-form");
    }
}
