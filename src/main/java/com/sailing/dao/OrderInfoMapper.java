package com.sailing.dao;

import com.sailing.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderInfoMapper {
     //插入新订单
    int insertSelective(Order order);
    //按古玩号和卖家id预约信息
    Order selectByuidAndantid(@Param("uid") String uid, @Param("antId") String antId);
    //买家id查找
    List<Order> selectByuid( @Param("uid") String uid);
    //卖家id查找
    List<Order> selectBySellerid( @Param("uid") String uid);
    //修改订单信息
    int updateSelectiveByOrderId(Order order);
    //通过订单号删除id
    int deleteByOrderId(String orderId);
    //根据订单号查找订单
    Order selectByOredrId(String orderId);

}
