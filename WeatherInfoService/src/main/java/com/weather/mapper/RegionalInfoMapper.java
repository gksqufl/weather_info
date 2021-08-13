package com.weather.mapper;

import com.weather.vo.CoronaInfoVO;
import com.weather.vo.CoronaSidoInfoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionalInfoMapper {
    public CoronaSidoInfoVO selectRegionalCoronaInfo(String region, String date);
    public CoronaInfoVO selectCoronaInfoRegionTotal(String date);
}
