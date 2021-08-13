package com.weather.service;

import com.weather.mapper.RegionalInfoMapper;
import com.weather.vo.CoronaInfoVO;
import com.weather.vo.CoronaSidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionalInfoService {
    @Autowired
    RegionalInfoMapper mapper;
    public CoronaSidoInfoVO selectRegionalCoronaInfo(String region, String date) {
        return mapper.selectRegionalCoronaInfo(region, date);
    }
    public CoronaInfoVO selectCoronaInfoRegionTotal(String date) {
        return mapper.selectCoronaInfoRegionTotal(date);
    }
}
