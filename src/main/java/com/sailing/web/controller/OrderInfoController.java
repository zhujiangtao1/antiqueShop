package com.sailing.web.controller;

import com.sailing.entity.*;
import com.sailing.entity.Vo.PicOrderInfoVo;
import com.sailing.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RequestMapping("/order")
@Controller
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private AntiqueInfoService antiqueInfoService;
    @Autowired
    private UserService userService;
    @Autowired
    private PicInfoService picInfoService;
    @Autowired
    private HistoryInfoService historyInfoService;
    @RequestMapping("/create")
    @ResponseBody
    public String insertOrderInfo(HttpServletRequest request, HttpSession session){
        String uid=(String) session.getAttribute("user");
        String antId=request.getParameter("id");
        AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(antId);
        //判断是不是本人上传的藏品
        System.out.println(antiqueInfo.getUid()+"------------qqqqqqwee--------------------"+uid);
        if(antiqueInfo.getUid().equals(uid)){
            return "your";
        }else {
            //判断是不是已经预约过过
                 if(orderInfoService.selectByuidAndantid(uid,antId)==null){
                     //找到当前古玩信息
                    AntiqueInfo antiqueInfo1= antiqueInfoService.selectAntiqueInfoByAntid(antId);
                     Order order=new Order();
                     //随机生成一个订单号
                     Random random = new Random();
                     int result = random.nextInt(60000) % 26001 + 34000;
                     order.setOrderId(String.valueOf(result));
                     order.setSellerId(antiqueInfo1.getUid());
                     order.setAntId(antId);
                     order.setBaseinfo(antiqueInfo1.getAntique_name());
                     Double price=antiqueInfo1.getPrice();
                     order.setAntPrice(price);
                     order.setAddress(antiqueInfo1.getAddress());
                     order.setBuyerId(uid);
                     order.setOrderTime(new Date());
                     System.out.println("------------------"+order);
                     orderInfoService.insertSelective(order);
                     return "success";
                 }else {
                     return "fail";
                 }
        }


    }

    @RequestMapping("/cancel")
    @ResponseBody
    public List<PicOrderInfoVo> selectOrder(HttpServletRequest request, HttpSession session){
        //删除指定订单
        String orderId=request.getParameter("id");
        orderInfoService.deleteByOrderId(orderId);

        //从session中拿到当前用户id
        String uid=(String) session.getAttribute("user");
        User user=userService.selectByUid(uid);

        List<PicOrderInfoVo> picOrderInfoVos=new ArrayList<PicOrderInfoVo>();

        //查找到订单
        List<Order>orders=orderInfoService.selectByuid(uid);
        //从每个订单的古玩号，找到指定图片，并存入集合
        for(Order order:orders){
            if(order.getOrderStatus().equals("未确认")){
                PicOrderInfoVo picOrderInfoVo=new PicOrderInfoVo();
                System.out.println("-------------------"+order);
                //从订单中查到古玩号
                String antid= order.getAntId();
                //古玩号查图片
                Pic pic=picInfoService.selectByAntId(antid);
                //第三方类中插入数据
                picOrderInfoVo.setOrder(order);
                picOrderInfoVo.setPic_url(pic.getPicUrl());
                picOrderInfoVo.setPhone(user.getUphone());
                System.out.println("-------------------"+picOrderInfoVo);
                //添加到集合中
                picOrderInfoVos.add(picOrderInfoVo);
                System.out.println("-----------------------"+picOrderInfoVos);
            }

        }
        return picOrderInfoVos;

    }

    @RequestMapping("/confirmation")
    @ResponseBody
    public List<PicOrderInfoVo> OrderBySellerofOK(HttpServletRequest request, HttpSession session, Model model){
        String orderId=request.getParameter("id");
        Order order2=orderInfoService.selectByOredrId(orderId);
      //改变当前订单状态
        Order order1=new Order();
        //插入当前订单id
        order1.setOrderId(orderId);
        order1.setOrderStatus("确认");
        orderInfoService.updateSelectiveByOrderId(order1);
        //改变古玩信息的状态
        AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(order2.getAntId());
        antiqueInfo.setIslocked("不可出售");
        antiqueInfoService.updataByAntId(antiqueInfo);
       //创建新的历史记录
        History history=new History();
        //随机一个历史订单id
        Random random = new Random();
        int result = random.nextInt(60000) % 30001 + 30000;
        Pic pic1=picInfoService.selectByAntId(order2.getAntId());
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaa++++++="+pic1);
        history.setHistoryId(String.valueOf(result));
        history.setAntId(order2.getAntId());
        history.setBaseinfo(order2.getBaseinfo());
        history.setBuyerId(order2.getBuyerId());
        history.setSellerId(order2.getSellerId());
        history.setAddress(order2.getAddress());
        history.setOrderTime(new Date());
        history.setPrice(order2.getAntPrice());
        history.setPic_url(pic1.getPicUrl());
        //插入历史订单
        historyInfoService.inserHistory(history);
        //从session中查到当前用户id
        String uid=(String) session.getAttribute("user");
        User user=userService.selectByUid(uid);

        List<PicOrderInfoVo> picOrderInfoVos=new ArrayList<>();

        //查找到订单
        List<Order>orders=orderInfoService.selectBySellerid(uid);

        //从每个订单的古玩号，找到指定图片，并存入集合
        for(Order order:orders){
            if(order.getOrderStatus().equals("未确认")){
                PicOrderInfoVo picOrderInfoVo=new PicOrderInfoVo();
                System.out.println("-------------------"+order);
                //从订单中查到古玩号
                String antid= order.getAntId();
                //古玩号查图片
                Pic pic=picInfoService.selectByAntId(antid);
                //第三方类中插入数据
                picOrderInfoVo.setOrder(order);
                picOrderInfoVo.setPic_url(pic.getPicUrl());
                picOrderInfoVo.setPhone(user.getUphone());
                System.out.println("-------------------"+picOrderInfoVo);
                //添加到集合中
                picOrderInfoVos.add(picOrderInfoVo);

            }

        }
        System.out.println("qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq"+picOrderInfoVos);
        return picOrderInfoVos;
    }

}
