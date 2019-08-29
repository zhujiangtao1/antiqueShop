package com.sailing.service;

import com.sailing.entity.History;

import java.util.List;

public interface HistoryInfoService {

    //插入历史记录
    int inserHistory(History history);
    //根据卖家号查历史订单
    List<History> selectBySellerid(String uid);
    //根据卖买号查历史订单
    List<History> selectByBuyerid(String uid);
}
