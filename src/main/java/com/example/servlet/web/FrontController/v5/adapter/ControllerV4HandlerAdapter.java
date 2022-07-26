package com.example.servlet.web.FrontController.v5.adapter;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.v4.ControllerV4;
import com.example.servlet.web.FrontController.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        return handler instanceof ControllerV4;
    }

    @Override
    public ModelView handle(HttpServletRequest req, HttpServletResponse response, Object Handler) throws SecurityException, IOException {
        ControllerV4 controller = (ControllerV4) Handler;

        Map<String, String> paramMap = createParamMap(req);
       HashMap<String, Object > model = new HashMap<>();

       String viewName =  controller.process(paramMap,model );

        ModelView mv = new ModelView(viewName);
        mv.setModel(model);

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }


}
