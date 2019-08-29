package com.sailing.web.controller;

import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Fav;
import com.sailing.entity.Pic;
import com.sailing.entity.Vo.PicFavAntiqueInfoVo;
import com.sailing.service.AntiqueInfoService;
import com.sailing.service.FavInfoService;
import com.sailing.service.PicInfoService;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/fav")
public class FavInfoController {
    @Autowired
    private FavInfoService favInfoService;
    @Autowired
    private AntiqueInfoService antiqueInfoService;
    @Autowired
    private PicInfoService picInfoService;
    @RequestMapping("/save")
    @ResponseBody
    public String saveFavInfo(HttpSession session, HttpServletRequest request){
        //从session中拿到当前用户id
        String uid=(String) session.getAttribute("user");
        String antId=request.getParameter("antId");
        Fav fav1=favInfoService.selectByuidAndAntid(uid,antId);
        System.out.println("1111111111111111111111111"+fav1);
       if(fav1==null){
             //随机生成一个收藏号
                  Random random = new Random();
                  int result = random.nextInt(60000) % 30001 + 30000;
                   Fav fav= new Fav();
                   fav.setFav_id(String.valueOf(result));
                   fav.setUid(uid);
                  fav.setAntId(antId);
                 int r=favInfoService.insertSelective(fav);
               System.out.println("--------------wwwwwwwwwwwwwwwwwwww"+r);
                    return "success";
      }
              else {
              return "successd";
          }
     }

     @RequestMapping("/delete")
     @ResponseBody
     public List<PicFavAntiqueInfoVo> deleteByFavid( HttpServletRequest request,HttpSession session){
        String favid=request.getParameter("id");
         System.out.println("11111111111111"+favid);
        favInfoService.deleteByFavid(favid);
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
        return picFavAntiqueInfoVos;
     }
}
