package com.example.servlet.web.FrontController.v2;

import com.example.servlet.web.FrontController.MyView;
import com.example.servlet.web.FrontController.v2.contoller.MemberFormControllerV2;
import com.example.servlet.web.FrontController.v2.contoller.MemberListControllerV2;
import com.example.servlet.web.FrontController.v2.contoller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2" , urlPatterns = "/front-controller/v2/*")
public class FrontControllerV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerV1Map = new HashMap<>();

    public FrontControllerV2() {
        controllerV1Map.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerV1Map.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerV1Map.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();

        ControllerV2 controller = controllerV1Map.get(requestURI);
        if(controller == null){
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        MyView view = controller.process(req, resp);
        view.render(resp,req);

    }
}
