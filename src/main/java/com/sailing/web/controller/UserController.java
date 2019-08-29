package com.sailing.web.controller;

import com.sailing.dao.UserMapper;
import com.sailing.entity.User;
import com.sailing.service.UserService;
import com.sailing.util.MD5Util;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/usercenter")
public class UserController {

    @Resource
    private UserMapper userdao;
    @Resource
    private UserService userService;

    //点击修改密码
    @RequestMapping("/updatepassword")
    public String toUpdatePassword(HttpServletRequest request) {
        String action = request.getParameter("action");
        return "user/updatepsw";
    }
    //确认修改密码
    @RequestMapping("/submitpassword")
    @ResponseBody
    public String UpdatePassword(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("user");
        User user =  userService.selectByUid(uid);
        if (!user.getUpassword().equals(request.getParameter("init"))) {
            return "fail";
        } else {
            user.setUid(uid);
            user.setUpassword(request.getParameter("new"));
            userService.updateByPrimaryKeySelective(user);
            return "success";
        }
    }
    //用户退出
    @RequestMapping("/out")
    public String userOut(HttpSession session){
        //session清除
        session.invalidate();
        return "login-multi";
    }
      //修改用户基本信息
    @RequestMapping("/saveuserinfo")
    @ResponseBody
    public ModelAndView saveuserinfo(ModelAndView modelAndView , HttpSession session, HttpServletRequest request){
        String uname=request.getParameter("uname");
        String usex=request.getParameter("usex");

        int uage=Integer.parseInt(request.getParameter("uage"));
        String uphone=request.getParameter("uphone");

        String uid= (String) session.getAttribute("user");
        User user=userService.selectByUid(uid);
        user.setUname(uname);
        user.setUsex(usex);
        user.setUage(uage);
        user.setUphone(uphone);
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa-==--0=="+user);
        //修改用户信息
        userService.updateByPrimaryKeySelective(user);
        //拿到修改后的用户信息
        User user1=userService.selectByUid(uid);
        modelAndView.addObject("user_Info",user1);
        modelAndView.setViewName("user/usercenter");
        return modelAndView;
    }
}
