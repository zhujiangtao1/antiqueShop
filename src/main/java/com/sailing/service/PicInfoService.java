package com.sailing.service;

import com.sailing.entity.Pic;
import org.apache.ibatis.annotations.Param;

public interface PicInfoService {
    int insertSelective(Pic pic);
    Pic selectByAntId(String antId);
    int deleteByAntid(String antId);
    //修改图片信息
    int updateByAntId(Pic pic);
}
