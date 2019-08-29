package com.sailing.service;

import com.sailing.entity.Order;
import org.apache.ibatis.annotations.Param;


import java.util.List;


public interface OrderInfoService {
    //插入新订单
    int insertSelective(Order order);
    //按古玩号和卖家id预约信息
    Order selectByuidAndantid(String uid, String antId);
    //通过买家id查找
    List<Order> selectByuid(String uid);
    //通过卖家id查找
    List<Order> selectBySellerid( @Param("uid") String uid);
    //通过订单号删除id
    int deleteByOrderId(String orderId);
    //修改订单信息
    int updateSelectiveByOrderId(Order order);
    //根据订单号查找订单
    Order selectByOredrId(String orderId);
}
