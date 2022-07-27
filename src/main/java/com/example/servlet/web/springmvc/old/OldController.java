package com.example.servlet.web.springmvc.old;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 컨트롤러를 찾으려면 다음과 같은 내용이 필요하다 .
// 1. HandlerMapping(핸들러 매핑)  : 이 컨트롤러를 찾을 수 있어야 한다. (스프링 빈 이름으로 등록이 되어있는지 )
// 2. HandlerAdapter(핸들러 어댑터) : 핸들러 매핑을 통해서 찾은 핸들러를 실행할 수 있는 핸들러 어댑터가 필요하다.
// 하지만 Spring은 자동으로 구현해주기 때문에 따로 개발자가 구현할 필요는 없다.
@Component("/springmvc/old-controller")
public class OldController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("OldController.handleRequest");
        // application.properties 에 등록한 prefix, suffix의 설정 정보를 사용해서 등록한다.
        // 그래서 view Name만 적어 사용할 수 있다.
        return new ModelAndView("new-form");
    }
}
