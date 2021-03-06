package com.sailing.web.controller;


import com.sailing.entity.User;
import com.sailing.service.LoginService;
import com.sailing.util.MD5Util;
import com.sailing.web.controller.TestController.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

//    @Autowired
//    UserMapper userMapper;
//    @Autowired
//    HttpSession session;

    /**
     * 显示登录界面,完成登录验证
     *
     * @return
     */
//    @Autowired
//    HistoryMapper historyMapper;
    @Resource
    private LoginService loginService;
    //登录界面
    @RequestMapping("/login")
    public String login() {
        return "login-multi";
    }
    //登录成功 进入主页
    @RequestMapping("/home")
    public String home(HttpServletRequest request) {

        return "home1.1";
    }
    //登录验证
    @RequestMapping("/checklogin")
    @ResponseBody
    public String checkLogin(HttpSession session, HttpServletRequest request) throws IOException {
        System.out.println("进去登录"+request.getParameter("username"));
        User user = loginService.checkLogin(request.getParameter("username"), request.getParameter("password"));
//        String user = user1.getUid();
        if (user != null) {
//            HttpSession session=request.getSession();
            session.setAttribute("user",user.getUid());
            session.setAttribute("username",user.getUsername());
            System.out.println("UCK:"+user);
            return "success";
        } else { return "fail";}
    }
    //游客访问 不保存sssion
    @RequestMapping("/visitor")
    public String vistorLogin(HttpServletRequest request){
        request.getSession().invalidate();
        return "home1.1";
    }
    //管理员登录
    @RequestMapping("/adminlogin")
    @ResponseBody
    public String checkAdminLogin(HttpServletRequest request,HttpSession session){
       String uid= request.getParameter("username");
        String password= request.getParameter("password");
        System.out.println(uid+"111111111111111111111"+password);
        if(uid.equals("zhujiangtao") && password.equals("123")){
            session.setAttribute("username",uid);
            return "success";
        }

        return "fail";
    }

//    //管理员进入历史订单
//    @RequestMapping("/history")
//    public ModelAndView historyManage(){
//        ModelAndView modelAndView = new ModelAndView();
//        List<History> historyList = historyMapper.selectHistoryAll();
//        modelAndView.addObject("itemsList",historyList);
//        modelAndView.setViewName("admin/history");
//        return modelAndView;
//    }
}
