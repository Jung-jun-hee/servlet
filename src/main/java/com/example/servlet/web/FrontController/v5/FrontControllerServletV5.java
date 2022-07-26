package com.example.servlet.web.FrontController.v5;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.MyView;
import com.example.servlet.web.FrontController.v3.controller.MemberFormControllerV3;
import com.example.servlet.web.FrontController.v3.controller.MemberListControllerV3;
import com.example.servlet.web.FrontController.v3.controller.MemberSaveControllerV3;
import com.example.servlet.web.FrontController.v4.controller.MemberFormControllerV4;
import com.example.servlet.web.FrontController.v4.controller.MemberListControllerV4;
import com.example.servlet.web.FrontController.v4.controller.MemberSaveControllerV4;
import com.example.servlet.web.FrontController.v5.adapter.ControllerV3HandlerAdapter;
import com.example.servlet.web.FrontController.v5.adapter.ControllerV4HandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "frontControllerServletV5", urlPatterns = "/front-controller/v5/*")
public class FrontControllerServletV5 extends HttpServlet {

    private final Map<String, Object> handlerMappingMap = new HashMap<>();
    private final List<MyHandlerAdapter> handlerAdapters = new ArrayList<>();

    public FrontControllerServletV5() {
        initHandlerMappingMap();
        initHandlerAdapters();
    }

    private void initHandlerAdapters() {
        handlerAdapters.add(new ControllerV3HandlerAdapter());
        handlerAdapters.add(new ControllerV4HandlerAdapter());
    }

    private void initHandlerMappingMap() {
        handlerMappingMap.put("/front-controller/v5/v3/members/new-form", new MemberFormControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members/save", new MemberSaveControllerV3());
        handlerMappingMap.put("/front-controller/v5/v3/members", new MemberListControllerV3());

        //v4 추가
        handlerMappingMap.put("/front-controller/v5/v4/members/new-form", new MemberFormControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members/save", new MemberSaveControllerV4());
        handlerMappingMap.put("/front-controller/v5/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object handler = getHandler(req);

        if(handler ==null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        MyHandlerAdapter adapter = getHandlerAdapter(handler);

        ModelView mv = adapter.handle(req, resp, handler);

        String viewName = mv.getViewName();
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), resp, req);

    }

    private MyHandlerAdapter getHandlerAdapter(Object handler) {
        MyHandlerAdapter a;
        for (MyHandlerAdapter adapter : handlerAdapters) {
            if(adapter.supports(handler)){
               return adapter;
            }
        }
        throw new IllegalArgumentException("handler adapter를 찾을 수 없습니다." + handler);
    }

    private Object getHandler(HttpServletRequest req) {
        String requestURI = req.getRequestURI();
       return handlerMappingMap.get(requestURI);
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}
