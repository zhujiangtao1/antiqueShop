package com.sailing.service;

import com.sailing.dao.OrderInfoMapper;
import com.sailing.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Autowired
    private OrderInfoMapper orderInfoMapper;
    @Override
    //插入新订单
    public int insertSelective(Order order) {
        return orderInfoMapper.insertSelective(order);
    }

    @Override
    public Order selectByuidAndantid(String uid, String antId) {
        return orderInfoMapper.selectByuidAndantid(uid,antId);
    }

    @Override
    public List<Order> selectByuid(String uid) {
        return orderInfoMapper.selectByuid(uid);
    }

    @Override
    public List<Order> selectBySellerid(String uid) {
        return orderInfoMapper.selectBySellerid(uid);
    }

    @Override
    public int deleteByOrderId(String orderId) {
        return orderInfoMapper.deleteByOrderId(orderId);
    }

    @Override
    public int updateSelectiveByOrderId(Order order) {
        return orderInfoMapper.updateSelectiveByOrderId(order);
    }

    @Override
    public Order selectByOredrId(String orderId) {
        return orderInfoMapper.selectByOredrId(orderId);
    }

}
