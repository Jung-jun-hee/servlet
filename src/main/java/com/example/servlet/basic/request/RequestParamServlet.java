package com.example.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/*
*   1. 파라미터 전송 기능
*   http://localhost:8080/request-param?username=hello&age=20
*
* */
@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 모든 요청 파라미터를 다 꺼낼 수 있다.
        System.out.println("전체 파라미터 조회 - start");
        req.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println("paramName = " + paramName +"=" + req.getParameter(paramName)));
        System.out.println("전체 파라미터 조회 - end");
        /*
        * request.getParameter()는 하나의 파라미터 이름에 대해서 단 하나의 값만 있을 때 사용해야 한다.
        * 지금처럼 중복인 상황이 발생헀을 경우 request.getParmeterValues()를 사용해야한다.
        * 하지만 이렇게 중복으로 보내는 경우는 거의 없다.
        * 그래서 request.getParameter를 가장 많이 사용한다.
        * */
        System.out.println("단일 파라미터 조회");
        String username = req.getParameter("username");
        String age = req.getParameter("age");
        System.out.println(username + "username");
        System.out.println(age + "age");


        System.out.println("요청 이름이 같은 복수 파라미터 조회");
        String[] usernames = req.getParameterValues("username");
        for(String name : usernames){
            System.out.println("username = " + name);
        }
        resp.getWriter().write("ok");

    }
}
