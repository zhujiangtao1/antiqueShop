package com.sailing.service;


import com.sailing.dao.PicMapper;
import com.sailing.entity.AntiqueInfo;
import com.sailing.entity.Pic;
import com.sailing.entity.Vo.PicAntInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PIcUrlImpl {
    @Autowired
    PicMapper picMapper;
    //输入CarInfo 得到包装类集合 含图片url和CarInfo
    public List<PicAntInfoVo> getPicAntInfo(List<AntiqueInfo> antiqueInfos){
        List<PicAntInfoVo> itemsList = new ArrayList<PicAntInfoVo>();
        for (AntiqueInfo antiqueInfo :antiqueInfos) {
            PicAntInfoVo picAntInfoVo = new PicAntInfoVo();
            picAntInfoVo.setAntiqueInfo(antiqueInfo);

            String pic_url="";
            List<Pic> pics =picMapper.selectByAntiqueId(antiqueInfo.getAntId());
//            List<Pic> pics = picMapper.selectByCarId(carInfo.getCarId());
            if(pics!=null && pics.size()>0){
                pic_url = pics.get(0).getPicUrl();
            }
            picAntInfoVo.setPic_url(pic_url);
            itemsList.add(picAntInfoVo);
            System.out.println("ppp1:"+picAntInfoVo.toString());
        }
        return itemsList;
    }
}
