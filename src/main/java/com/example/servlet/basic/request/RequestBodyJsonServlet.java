package com.example.servlet.basic.request;

import com.example.servlet.basic.HelloData;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
public class RequestBodyJsonServlet extends HttpServlet {

    // Json 결과를 파싱해서 사용할 수 있는 자바 객체로 변환하려면 Jackson, Gson 같은 Json 변환 라이브러리를 추가해서
    //사용해야한다. 스프링 부트로 Spring MVC를 선택하면 기본으로 Jackson 라이브러리('ObjectMapper')를 함께 제공한다.
    private ObjectMapper objectMapper = new ObjectMapper();
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // HTTP 메세지 바디에 있는거 다 출력
        // 이렇게 HTML form 데이터도 메시지 바디를 통해 전소오디므로 직접 읽을 수 있다.
        // 하지만 편리한 파라미터 조회 기능 (request.getParameter)을 이미 제공하기 때문에 파라미터 조회 기능을 사용하면 된다.
        ServletInputStream inputStream = req.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        System.out.println("messageBody = " + messageBody);

        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData = " + helloData.getUsername());
        System.out.println("helloData.getAge = " + helloData.getAge());
    }
}
