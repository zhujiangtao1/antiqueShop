package com.sailing.service;

import com.sailing.dao.HistoryInfoMapper;
import com.sailing.entity.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryInfoServiceImpl implements HistoryInfoService {
    @Autowired
    private HistoryInfoMapper historyInfoMapper;
    @Override
    public int inserHistory(History history) {
        return historyInfoMapper.inserHistory(history);
    }

    @Override
    public List<History> selectBySellerid(String uid) {
        return historyInfoMapper.selectBySellerid(uid);
    }

    @Override
    public List<History> selectByBuyerid(String uid) {
        return historyInfoMapper.selectByBuyerid(uid);
    }
}
