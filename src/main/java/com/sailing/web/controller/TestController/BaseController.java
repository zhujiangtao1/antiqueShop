package com.sailing.web.controller.TestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class BaseController {
    @Autowired
    protected HttpSession session;
    @Autowired
    protected HttpServletRequest request;
}
