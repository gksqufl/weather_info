package com.weather.mapper;

import com.weather.vo.CoronaInfoSidoVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CoronaInfoSidoMapper {
    public void insertCoronaInfoSido(CoronaInfoSidoVO vo);
}
