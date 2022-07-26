package com.example.servlet.web.FrontController.v5;

import com.example.servlet.web.FrontController.ModelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface MyHandlerAdapter {
    boolean supports(Object handler);

    ModelView handle(HttpServletRequest req, HttpServletResponse response, Object Handler) throws SecurityException, IOException;
}
