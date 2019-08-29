package com.sailing.service;

import com.sailing.entity.Fav;

import java.util.List;

public interface FavInfoService {
    int insertSelective(Fav fav);
    //uid和古玩id查找收藏表
    Fav selectByuidAndAntid(String uid,String antId);
    //uid查找收藏表
    List<Fav> selectByuid(String uid);
    //按古玩号来删除收藏信息
    int deleteByantId(String antId);
    //按收藏号删除收藏信息
    int deleteByFavid(String favid);
}
