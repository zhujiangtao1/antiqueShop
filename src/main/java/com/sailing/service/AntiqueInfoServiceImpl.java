package com.sailing.service;

import com.sailing.dao.AntiqueInfoMapper;
import com.sailing.entity.AntiqueInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AntiqueInfoServiceImpl implements AntiqueInfoService {
    @Autowired
    private AntiqueInfoMapper antiqueInfoMapper;
    @Override
    public List<AntiqueInfo> selectAntiqueInfoAll() {
        return antiqueInfoMapper.selectAntiqueInfoAll();
    }

    @Override
    public AntiqueInfo selectAntiqueInfoByAntid(String antId) {
        return antiqueInfoMapper.selectAntiqueInfoByAntid(antId);
    }

    @Override
    public int insertSelective(AntiqueInfo antiqueInfo) {
        return antiqueInfoMapper.insertSelective(antiqueInfo);
    }

    @Override
    public List<AntiqueInfo> selectAntiqueByuid(String uid) {
        return antiqueInfoMapper.selectAntiqueByuid(uid);
    }

    @Override
    public int updataByAntId(AntiqueInfo antiqueInfo) {
        return antiqueInfoMapper.updataByAntId(antiqueInfo);
    }

    @Override
    public int deleteByantId(String antId) {
        return antiqueInfoMapper.deleteByantId(antId);
    }
}
