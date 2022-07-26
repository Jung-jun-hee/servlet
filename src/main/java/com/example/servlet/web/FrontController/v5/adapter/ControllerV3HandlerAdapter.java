package com.example.servlet.web.FrontController.v5.adapter;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.v3.ControllerV3;
import com.example.servlet.web.FrontController.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse response, Object Handler) throws SecurityException, IOException {
        ControllerV3 controller = (ControllerV3) Handler;
        Map<String, String> paramMap = createParamMap(req);

        ModelView mv = controller.process(paramMap);
        return mv;
    }
    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
