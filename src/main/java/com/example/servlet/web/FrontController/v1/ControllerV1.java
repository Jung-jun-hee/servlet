package com.example.servlet.web.FrontController.v1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.rmi.server.ServerCloneException;

public interface ControllerV1 {

    void process(HttpServletRequest req, HttpServletResponse resp) throws  IOException, ServletException;

}
