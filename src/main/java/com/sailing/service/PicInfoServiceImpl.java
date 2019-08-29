package com.sailing.service;

import com.sailing.dao.PicMapper;
import com.sailing.entity.Pic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PicInfoServiceImpl implements PicInfoService {
    @Autowired
    private PicMapper picMapper;
    @Override
    public int insertSelective(Pic pic) {
        return picMapper.insertSelective(pic);
    }

    @Override
    public Pic selectByAntId(String antId) {
        return picMapper.selectByAntId(antId);
    }

    @Override
    public int deleteByAntid(String antId) {
        return picMapper.deleteByAntid(antId);
    }

    @Override
    public int updateByAntId(Pic pic) {
        return picMapper.updateByAntId(pic);
    }
}
