package com.example.servlet.basic.reponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Response가 지원하는 기능들 ...


        // HTTP 응답 코드를 넣어줄 수 있다.
        // [status-Line]
        resp.setStatus(HttpServletResponse.SC_OK);

        // HTTP 컨텐트 타입을 직접 세팅해줄 수 있다.
        // 쿠키도 지정해 줄 수 있다. (setCookie)
        // redirect도 설정할 수 있다 (sendRedirect 사용 )
        //[response-headers]
        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cashe-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hello");

        // message body로 단순 텍스트 응답도 쓸 수 있다.
        PrintWriter writer = resp.getWriter();
        writer.println("하이");

    }
}
