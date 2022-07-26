package com.example.servlet.web.FrontController.v3;

import com.example.servlet.web.FrontController.ModelView;

import java.util.Map;

public interface ControllerV3 {

    ModelView process(Map<String, String> paramMap);
}
