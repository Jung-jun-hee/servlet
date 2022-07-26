package com.example.servlet.web.FrontController.v4;

import com.example.servlet.web.FrontController.ModelView;
import com.example.servlet.web.FrontController.MyView;
import com.example.servlet.web.FrontController.v3.ControllerV3;
import com.example.servlet.web.FrontController.v3.controller.MemberFormControllerV3;
import com.example.servlet.web.FrontController.v3.controller.MemberListControllerV3;
import com.example.servlet.web.FrontController.v3.controller.MemberSaveControllerV3;
import com.example.servlet.web.FrontController.v4.controller.MemberFormControllerV4;
import com.example.servlet.web.FrontController.v4.controller.MemberListControllerV4;
import com.example.servlet.web.FrontController.v4.controller.MemberSaveControllerV4;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV4" , urlPatterns = "/front-controller/v4/*")
public class FrontControllerV4 extends HttpServlet {

    private Map<String, ControllerV4> controllerV1Map = new HashMap<>();

    public FrontControllerV4() {
        controllerV1Map.put("/front-controller/v4/members/new-form", new MemberFormControllerV4());
        controllerV1Map.put("/front-controller/v4/members/save", new MemberSaveControllerV4());
        controllerV1Map.put("/front-controller/v4/members", new MemberListControllerV4());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();

        ControllerV4 controller = controllerV1Map.get(requestURI);
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        Map<String, String> paramMap = createParamMap(req);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);

        MyView view = viewResolver(viewName);

        view.render(model,resp,req);

    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest req) {
        Map<String, String> paramMap = new HashMap<>();
        req.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, req.getParameter(paramName)));
        return paramMap;
    }
}
