package com.sailing.service;

import com.sailing.dao.FavInfoMapper;
import com.sailing.entity.Fav;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavInfoServiceImpl implements  FavInfoService{
    @Autowired
    private FavInfoMapper favInfoMapper;
    @Override
    public int insertSelective(Fav fav) {
        return favInfoMapper.insertSelective(fav);
    }

    @Override
    public Fav selectByuidAndAntid(String uid, String antId) {
        return favInfoMapper.selectByuidAndAntid(uid,antId);
    }

    @Override
    public List<Fav> selectByuid(String uid) {
        return favInfoMapper.selectByuid(uid);
    }

    @Override
    public int deleteByantId(String antId) {
        return favInfoMapper.deleteByantId(antId);
    }

    @Override
    public int deleteByFavid(String favid) {
        return favInfoMapper.deleteByFavid(favid);
    }


}
