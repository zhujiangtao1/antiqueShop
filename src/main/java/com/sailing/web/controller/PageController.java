package com.sailing.web.controller;

import com.sailing.dao.PicMapper;
import com.sailing.entity.*;
import com.sailing.entity.Vo.PicAntInfoVo;
import com.sailing.entity.Vo.PicFavAntiqueInfoVo;
import com.sailing.entity.Vo.PicOrderInfoVo;
import com.sailing.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    private UserService userService;
    @Autowired
    private AntiqueInfoService antiqueInfoService;
    @Autowired
    PIcUrlImpl pIcUrl;
    @Autowired
    PicMapper picMapper;
    @Autowired
    private OrderInfoService orderInfoService;
    @Autowired
    private PicInfoService picInfoService;
    @Autowired
    private HistoryInfoService historyInfoService;
    @Autowired
    private  FavInfoService favInfoService;
    @Autowired
    private CommentService commentService;
    //进入首页
    @RequestMapping("/index")
    public String showIndex(HttpSession session)
    {
//        String id = "36331";
//        session.setAttribute("user",id);
        return "home1.1";
    }

    @RequestMapping("/showCar")
    public ModelAndView showCarInfo() throws Exception {
        List<AntiqueInfo>itemsListTempt=antiqueInfoService.selectAntiqueInfoAll();
        List<AntiqueInfo>itemsListAll=new ArrayList<AntiqueInfo>();

        for(AntiqueInfo antiqueInfo:itemsListTempt){
            if(antiqueInfo.getIslocked().equals("可出售")){
                System.out.println("----------------"+antiqueInfo);
                itemsListAll.add(antiqueInfo);
            }
        }
        //调用getPIcCarInfo方法 封装图片url和carInfo
        List<PicAntInfoVo> itemsList = pIcUrl.getPicAntInfo(itemsListAll);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList", itemsList);
        //指定逻辑视图名itemsList
        modelAndView.setViewName("car/buy0");

        return modelAndView;
    }
    @RequestMapping("/details")
    public ModelAndView showDetails(HttpSession session,Integer id) throws Exception {
        //古玩个人的信息
       AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(String.valueOf(id));
       //拿到这个古玩的所有评论
        List<Comment>comments=commentService.selectByAntid(antiqueInfo.getAntId());
        System.out.println("???????????????????"+comments);
       PicAntInfoVo antInfo=new PicAntInfoVo();
       antInfo.setAntiqueInfo(antiqueInfo);
        String pic_url ="";
        List<Pic> pics=picMapper.selectByAntiqueId(antiqueInfo.getAntId());
        if(pics!=null && pics.size()>0){
            pic_url = pics.get(0).getPicUrl();
        }
        antInfo.setPic_url(pic_url);

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("antInfo", antInfo);
        modelAndView.addObject("comments",comments);
        modelAndView.setViewName("car/details0");
        return modelAndView;
    }
       @RequestMapping("/user")
       @ResponseBody
       //个人中心
    public ModelAndView showUser(HttpSession session)  {
       String uid=(String) session.getAttribute("user");
        User user=userService.selectByUid(uid);
           ModelAndView modelAndView=new ModelAndView();
           modelAndView.addObject("user_Info",user);
           modelAndView.setViewName("user/usercenter");
           return modelAndView;

    }
    //买方预约的订单
    @RequestMapping("/order")
    @ResponseBody
    public ModelAndView showBuyerOrder(HttpSession session){
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

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("picOrderInfoVos",picOrderInfoVos);

        modelAndView.setViewName("user/unfinished_order");
        return modelAndView;
    }
    //卖家收到的订单列表
    @RequestMapping("/check_order")
    @ResponseBody
      public ModelAndView showSellerOrder(HttpSession session){
        String uid=(String) session.getAttribute("user");
        List<PicOrderInfoVo> picOrderInfoVos=new ArrayList<PicOrderInfoVo>();
        //查找到订单
        List<Order>orders=orderInfoService.selectBySellerid(uid);
        for( Order order:orders){
            String buyerid=order.getBuyerId();
            User user=userService.selectByUid(buyerid);
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
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("picOrderInfoVos",picOrderInfoVos);

        modelAndView.setViewName("user/check_order");
        return modelAndView;

      }
      //作为卖放发布的所有古玩信息
    @RequestMapping("/check_car")
    @ResponseBody
      public  ModelAndView showSellerAllantique(HttpSession session){
        //拿到session中的uid
          String uid=(String) session.getAttribute("user");
          //根据用户id查找到，用户所发布的所有古玩信息
          List<AntiqueInfo> antiqueInfos=antiqueInfoService.selectAntiqueByuid(uid);
          List<PicAntInfoVo> picAntInfoVos=new ArrayList<PicAntInfoVo>();
          for(AntiqueInfo antiqueInfo:antiqueInfos){
              PicAntInfoVo picAntInfoVo=new PicAntInfoVo();
              String antId=antiqueInfo.getAntId();
              Pic pic=picInfoService.selectByAntId(antId);
              picAntInfoVo.setPic_url(pic.getPicUrl());
              picAntInfoVo.setAntiqueInfo(antiqueInfo);
              picAntInfoVos.add(picAntInfoVo);
          }
          ModelAndView modelAndView=new ModelAndView();
          modelAndView.addObject("picAntInfoVos",picAntInfoVos);
          modelAndView.setViewName("user/check_car");
          return modelAndView;

      }
    @RequestMapping("/shistory")
    @ResponseBody
      public ModelAndView HistoryBySeller(HttpSession session, ModelAndView modelAndView){
           String uid= (String) session.getAttribute("user");
           List<History>histories=historyInfoService.selectBySellerid(uid);
        System.out.println("qqqqqqqqqqqqq"+histories);
          modelAndView.addObject("histories",histories);
          modelAndView.setViewName("user/sell_history");
          return modelAndView;
      }
    @RequestMapping("/bhistory")
    @ResponseBody
    public ModelAndView HistoryByBuyer(HttpSession session, ModelAndView modelAndView){
        String uid= (String) session.getAttribute("user");
        List<History>histories=historyInfoService.selectByBuyerid(uid);
        System.out.println("qqqqqqqqqqqqq"+histories);
        modelAndView.addObject("histories",histories);
        modelAndView.setViewName("user/buy_history");
        return modelAndView;
    }
    @RequestMapping("/collection")
    @ResponseBody
      public ModelAndView collection(HttpSession session,ModelAndView modelAndView){
        String uid= (String) session.getAttribute("user");
        List<Fav>favs=favInfoService.selectByuid(uid);
        System.out.println("qqqqqqqqqqqqqqq"+favs);
        List<PicFavAntiqueInfoVo> picFavAntiqueInfoVos=new ArrayList<PicFavAntiqueInfoVo>();
        for(Fav fav:favs){
            PicFavAntiqueInfoVo picFavAntiqueInfoVo=new PicFavAntiqueInfoVo();
            //通过古玩号查到当前古玩
            AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(fav.getAntId());
            //通过古玩id查找到当前图片
            System.out.println("00000000000000000000000"+fav);
            String antId=fav.getAntId();
            Pic pic=picInfoService.selectByAntId(antId);
            System.out.println("1111111111111111111"+pic);
            //生成复合类
            picFavAntiqueInfoVo.setAntiqueInfo(antiqueInfo);
            picFavAntiqueInfoVo.setFav(fav);
            picFavAntiqueInfoVo.setPic_url(pic.getPicUrl());
            //插入复合类的集合，方便一起在前台打印
            picFavAntiqueInfoVos.add(picFavAntiqueInfoVo);

        }
          modelAndView.addObject("picFavAntiqueInfoVos",picFavAntiqueInfoVos);
          modelAndView.setViewName("user/collection");
          return modelAndView;

      }
}
