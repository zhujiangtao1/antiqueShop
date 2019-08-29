package com.sailing.web.controller;

import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Pic;
import com.sailing.service.AntiqueInfoService;
import com.sailing.service.PIcUrlImpl;
import com.sailing.service.PicInfoService;
import com.sailing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/home")
public class HomeController {
 @Autowired
    private PIcUrlImpl pIcUrl;
 @Autowired
 private PicInfoService picInfoService;
 @Autowired
    private AntiqueInfoService antiqueInfoService;
    //主页：我要卖车

    @RequestMapping("/sellcar")
    @ResponseBody
    public String sellCar(@RequestParam("file") MultipartFile file, AntiqueInfo antiqueInfo,  HttpSession session) throws IOException {
        String sqlPath = null;
        //定义文件保存的项目中img目录中
        String localPath="D:\\images/";
        //定义 文件名
        String filename=null;
        //过去原文件名
        String oldFilname=file.getOriginalFilename();
        //session中找到用户id，并插入到古玩信息中
        String uid= (String) session.getAttribute("user");
        antiqueInfo.setUid(uid);
        //随机生成一个古玩id
        Random random = new Random();
        int result = random.nextInt(60000) % 26001 + 34000;
        antiqueInfo.setAntId(String.valueOf(result));
       antiqueInfoService.insertSelective(antiqueInfo);
            if (!file.isEmpty()) {
                //随机生成图片名
                UUID uuid= UUID.randomUUID();
                //在加上源文件的后缀
                filename=uuid+oldFilname.substring(oldFilname.lastIndexOf("."));

                sqlPath="/images/"+filename;
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaa"+sqlPath);
                //随机生成一个图片id
                int result1 = random.nextInt(60000) % 26001 + 34000;
                Pic pic=new Pic();
                pic.setPicId(String.valueOf(result1));
                //插入图片存贮路劲
                pic.setPicUrl(sqlPath);
                //图片表中的古玩id
                pic.setAntid(String.valueOf(result));

              picInfoService.insertSelective(pic);
                    //存入图片
                    file.transferTo(new File(localPath+filename));
                    return "发布成功！";
                }else {
                return "发布失败";
            }

            }



        }




