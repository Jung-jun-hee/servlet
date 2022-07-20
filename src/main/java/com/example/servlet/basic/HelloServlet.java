package com.example.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// 서블릿은 Http Servlet을 상속받아야 한다.
// HTTP 요청 메시지를 직접 파싱해서 사용해도 되지만 매번 확인하기 불편하기 때문에 서블릿은
// 개발자가 HTTP 요청 메시지를 편리하게 사용할 수 있도록 개발자 대신 HTTP 요청 메시지를 파싱한다.
// 그리고 그 결과를 HttpServletRequest 객체에 담아서 제공한다.
// 추가로 임시 저장 기능과 세션 관리 기능을 수행한다.
// request.setAttribute 안에 저장소에서 HTTP 요청 메시지가 생성되어 있는동안 저장소를 사용할 수 있다.
// request.getSession(create: true) 세션 관리 가능

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 서블릿 애노테이션
public class HelloServlet extends HttpServlet {
    
    // 이 서블릿이 호출이 되면 여기 서비스도 호출이 된다 .
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("호출호출");

       // 화면에서 보낸 쿼리 파라미터를 읽어올 수 있다.
         String userName = req.getParameter("name");

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("utf-8");
        // 응답 메세지에 직접 담아 화면에 쓸 수 있다.
        resp.getWriter().write("hello" + userName);

    }
}
