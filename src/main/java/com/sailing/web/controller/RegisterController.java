package com.sailing.web.controller;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import com.sailing.service.LoginService;
import com.sailing.util.MD5Util;
import com.sailing.util.ServiceException;
import net.sf.json.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;

@RequestMapping("/register")
//注册
@Controller
public class RegisterController {
    @Resource
    private LoginService loginService;
    @Resource
    private UserMapper userdao;

    //注册
    @RequestMapping("/do")
    @ResponseBody
    public String load(HttpServletRequest request) throws ParseException, ServiceException {
        String name=request.getParameter("username");
        String password=request.getParameter("password");
        String phone=request.getParameter("phone");
        System.out.println("---------"+request.getParameter("username"));
        User user1 = userdao.selectByUsername(request.getParameter("username"));
            if (user1 == null) {
                User user = new User();
                Random random = new Random();
                int result = random.nextInt(60000) % 30001 + 30000;
                user.setUid(String.valueOf(result));
                user.setUsername(name);
                user.setUpassword(password);
                user.setUphone(phone);
                user.setUregistertime(new Date());
                user.setUstatus((byte) 0);
                System.out.println(user);
                userdao.insertSelective(user);
                return "success";

            } else {
                return "fail";
            }

    }
}


