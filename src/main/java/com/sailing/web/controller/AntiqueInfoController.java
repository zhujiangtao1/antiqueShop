package com.sailing.web.controller;

import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Pic;
import com.sailing.entity.Vo.PicAntInfoVo;
import com.sailing.service.AntiqueInfoService;
import com.sailing.service.FavInfoService;
import com.sailing.service.PIcUrlImpl;
import com.sailing.service.PicInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("antiqueInfo")
public class AntiqueInfoController {
    @Autowired
    private AntiqueInfoService antiqueInfoService;
    @Autowired
    private PIcUrlImpl pIcUrl;
    @Autowired
    private PicInfoService picInfoService;
    @Autowired
    private FavInfoService favInfoService;
    //buy页面 筛选汽车信息
    @RequestMapping("/selectCar")
    @ResponseBody
    public List<PicAntInfoVo> selectAntique(AntiqueInfo antiqueInfo, double price1, double price2){
        System.out.println(antiqueInfo);
        List<AntiqueInfo> itemsListAll=antiqueInfoService.selectAntiqueInfoAll();
        List<AntiqueInfo> itemsListAnt=new ArrayList<AntiqueInfo>();
        List<AntiqueInfo> itemsListTempt=new ArrayList<AntiqueInfo>();
        itemsListTempt.addAll(itemsListAll);
        System.out.println("-----------------"+itemsListTempt);
        //选择可出售的古玩
        itemsListAnt.clear();
        for(AntiqueInfo item:itemsListTempt){
            if(item.getIslocked().equals("可出售")){
                itemsListAnt.add(item);
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListAnt);
        System.out.println("--------可出售---------"+itemsListTempt);

        //筛选朝代
        itemsListAnt.clear();
        if(antiqueInfo.getYears().equals("0")){
            itemsListAnt.addAll(itemsListTempt);
        }else {
            for(AntiqueInfo item:itemsListTempt){
                if(item.getYears().equals(antiqueInfo.getYears())){
                    itemsListAnt.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListAnt);
        System.out.println("--------可出售---- 朝代-----"+itemsListTempt);

        //筛选类别
        itemsListAnt.clear();
        if(antiqueInfo.getCategory().equals("0")){
            itemsListAnt.addAll(itemsListTempt);
        }else {
            for(AntiqueInfo item:itemsListTempt){
                if(item.getCategory().equals(antiqueInfo.getCategory())){
                    itemsListAnt.add(item);
                }
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListAnt);
        System.out.println("-----类别---可出售---- 朝代-----"+itemsListTempt);

        //筛选价格
        itemsListAnt.clear();
        for(AntiqueInfo item:itemsListTempt){
            if(item.getPrice()<=price2 && item.getPrice()>price1 ){
                itemsListAnt.add(item);
            }
        }
        itemsListTempt.clear();
        itemsListTempt.addAll(itemsListAnt);
        System.out.println("-----类别---可出售---- 朝代---价格--"+itemsListTempt);
        List<PicAntInfoVo>itemsList =pIcUrl.getPicAntInfo(itemsListAnt);
        return itemsList;

    }
    @RequestMapping("/delete")
    @ResponseBody
    public List<PicAntInfoVo> deleteAntique(HttpSession session, HttpServletRequest request){
        String antid=request.getParameter("id");
        //删除指定古玩信息
        antiqueInfoService.deleteByantId(antid);
        //删除图片
        picInfoService.deleteByAntid(antid);
        //删除关于这个古玩的所有收藏信息
        favInfoService.deleteByantId(antid);
        //拿到session中的uid
        String uid=(String) session.getAttribute("user");
        //根据用户id查找到，用户所发布的所有古玩信息
        List<AntiqueInfo> antiqueInfos=antiqueInfoService.selectAntiqueByuid(uid);
        List<PicAntInfoVo> picAntInfoVos=new ArrayList<PicAntInfoVo>();
        for(AntiqueInfo antiqueInfo:antiqueInfos){
            PicAntInfoVo picAntInfoVo=new PicAntInfoVo();
            //从古玩信息中拿到古玩号
            String antId=antiqueInfo.getAntId();
            //古玩号查找到图片
            Pic pic=picInfoService.selectByAntId(antId);
            picAntInfoVo.setPic_url(pic.getPicUrl());
            picAntInfoVo.setAntiqueInfo(antiqueInfo);
            picAntInfoVos.add(picAntInfoVo);
        }
          return picAntInfoVos;
    }
    @RequestMapping("/find")
    @ResponseBody
    public AntiqueInfo findByantId(HttpServletRequest request){
        String antId=request.getParameter("id");
        AntiqueInfo antiqueInfo=antiqueInfoService.selectAntiqueInfoByAntid(antId);
        System.out.println("aaaaaaaaaaaaaaaaaaaa"+antiqueInfo);
        return antiqueInfo;
    }
    @RequestMapping("/updata")
    @ResponseBody
    public String AntiqueByUpdata(@RequestParam("file") MultipartFile file,AntiqueInfo antiqueInfo) throws IOException {

        String sqlPath = null;
        //定义文件保存的项目中img目录中
        String localPath="D:\\images/";
        //定义 文件名
        String filename=null;
        //过去原文件名
        String oldFilname=file.getOriginalFilename();
        antiqueInfoService.updataByAntId(antiqueInfo);
        System.out.println("1111111111111111"+antiqueInfo);
        if (!file.isEmpty()) {
            //随机生成图片名
            UUID uuid= UUID.randomUUID();
            //在加上源文件的后缀
            filename=uuid+oldFilname.substring(oldFilname.lastIndexOf("."));

            sqlPath="/images/"+filename;
            System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+sqlPath);
            Pic pic=picInfoService.selectByAntId(antiqueInfo.getAntId());
            //插入图片存贮路劲
            pic.setPicUrl(sqlPath);
            picInfoService.updateByAntId(pic);
            //存入图片
            file.transferTo(new File(localPath+filename));
            String mag="1";
            return mag;
        }else {
            String mag="2";
            return mag;
        }

    }


}

