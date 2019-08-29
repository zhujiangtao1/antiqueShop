package com.sailing.web.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Pic;
import com.sailing.entity.User;
import com.sailing.entity.Vo.PicAntInfoVo;
import com.sailing.service.AntiqueInfoService;
import com.sailing.service.PicInfoService;
import com.sailing.service.UserService;
import com.sailing.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/admin")
public class AdminController  {
    @Autowired
  private UserService userService;
    @Autowired
    private AntiqueInfoService antiqueInfoService;
    @Autowired
    private PicInfoService picInfoService;



    //进入管理页面
    @RequestMapping("/member")
      public String adminLogin(){
        return "/admin/member";
    }
    //进入管理页面
    @RequestMapping("/antique")
    public String adminLoginByantique(){
        return "/admin/antique";
    }



   @RequestMapping("/antAll")
   @ResponseBody
  public Msg getAllantique(@RequestParam(value = "pn",defaultValue = "1") int pn){

       // 引入PageHelper分页插件
       // 在查询之前只需要调用，传入页码，以及每页的大小
       PageHelper.startPage(pn, 3);

       List<AntiqueInfo>antiqueInfos=antiqueInfoService.selectAntiqueInfoAll();
       // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
       // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
       PageInfo page = new PageInfo(antiqueInfos, 3);
       return  Msg.success().add("pageInfo",page);
  }


    @RequestMapping("/user")
    @ResponseBody
    public Msg getAlluser(@RequestParam(value = "pn",defaultValue = "1") int pn){
        // 引入PageHelper分页插件
        // 在查询之前只需要调用，传入页码，以及每页的大小
        PageHelper.startPage(pn, 3);
        // startPage后面紧跟的这个查询就是一个分页查询
        List<User> users=userService.selectAll();
        System.out.println("11111111111"+users);
        // 使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了。
        // 封装了详细的分页信息,包括有我们查询出来的数据，传入连续显示的页数
        PageInfo page = new PageInfo(users, 3);
        return  Msg.success().add("pageInfo",page);
    }

    @RequestMapping("/find")
    @ResponseBody
    public User findByusername(HttpServletRequest request){
        String username=request.getParameter("id");
        User user=userService.selectByUsername(username);

        return user;

    }
    @RequestMapping("/antfind")
    @ResponseBody
    public AntiqueInfo findAntiqueInfoByuid(HttpServletRequest request){
        String uid=request.getParameter("id");
        AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(uid);

        return antiqueInfo ;

    }
    @RequestMapping("/Byuserid")
    @ResponseBody
    public User findByuid(HttpServletRequest request){
        String uid=request.getParameter("id");
        User user=userService.selectByUid(uid);
        return user;

    }
    //响应页面的删除
    @RequestMapping("delete")
    @ResponseBody
    public Msg deleteUserById(HttpServletRequest request) {
        //return userService.deleteUserById(id)>0?"ok":"error";
        String uid=request.getParameter("id");
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqq"+uid);
        userService.deleteByPrimaryKey(uid);
        return Msg.success();

    }
    @RequestMapping("/updata")
    @ResponseBody
    public  String updataUser(HttpServletRequest request,User user){

        System.out.println("999999999999999999999999999999"+user);
        userService.updateByPrimaryKeySelective(user);
        return "1";
    }
}
