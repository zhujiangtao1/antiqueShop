package com.sailing.dao;

import com.sailing.entity.Pic;
import com.sailing.entity.PicKey;

import java.util.List;

public interface PicMapper {

    int deleteByAntid(String antId);

    int insert(Pic record);

    int insertSelective(Pic pic);

    Pic selectByPrimaryKey(PicKey key);

    int updateByPrimaryKeySelective(Pic pic);

    int updateByPrimaryKey(Pic record);
    //根据古玩号查找图片
    List<Pic> selectByAntiqueId(String antId);
    Pic selectByAntId(String antId);
    //修改图片信息
    int updateByAntId(Pic pic);
}
