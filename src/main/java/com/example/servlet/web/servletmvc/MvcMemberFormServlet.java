package com.example.servlet.web.servletmvc;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // MVC는 항상 컨트롤러 요청을 통해 들어와야 한다.
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // 컨트롤러에서 뷰로 이동할 때 dispatcher를 통해서 이동하게 된다.
        RequestDispatcher dispatcher = req.getRequestDispatcher(viewPath);
        // 다른 서블릿이나 jsp로 이동할 수 있는 기능이다. 서버 내부에서 다시 호출이 발생한다.
        dispatcher.forward(req,resp);
    }

}
