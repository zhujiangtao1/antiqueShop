package com.sailing.dao;


import com.sailing.entity.Fav;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FavInfoMapper {
          //插入收藏表
    int  insertSelective(Fav fav);
    //uid和古玩id查找收藏表
    Fav selectByuidAndAntid(@Param("uid") String uid, @Param("antId") String antId);
    //uid查找收藏表
    List<Fav> selectByuid(String uid);
    //按古玩号来删除收藏信息
    int deleteByantId(String antId);
    //按收藏号删除收藏信息
    int deleteByFavid(String favid);
}
