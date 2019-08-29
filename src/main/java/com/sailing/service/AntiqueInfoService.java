package com.sailing.service;

import com.sailing.entity.AntiqueInfo;

import java.util.List;

public interface AntiqueInfoService {
    //查找所有
    List<AntiqueInfo>selectAntiqueInfoAll();
    //按古玩id查找
    AntiqueInfo selectAntiqueInfoByAntid(String antId);
    //按插入新古玩
    int insertSelective(AntiqueInfo antiqueInfo);
    //按用户号查找已发布的古玩信息
    List<AntiqueInfo>selectAntiqueByuid(String uid);
    //按古玩号修改古玩信息
    int updataByAntId(AntiqueInfo antiqueInfo);
    //按古玩号删除
    int deleteByantId(String antId);
}
