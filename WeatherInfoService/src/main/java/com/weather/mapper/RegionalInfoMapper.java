package com.weather.mapper;

import java.util.List;

import com.weather.vo.CoronaInfoVO;
import com.weather.vo.CoronaSidoInfoVO;
import com.weather.vo.CoronaVaccineInfoVO;
import com.weather.vo.CoronaVaccineWeeksVO;
import com.weather.vo.CoronaWeeksVO;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegionalInfoMapper {
    public CoronaSidoInfoVO selectRegionalCoronaInfo(String region, String date);
    public CoronaInfoVO selectCoronaInfoRegionTotal(String date);
    public CoronaVaccineInfoVO selectCoronaVaccineInfo(String region, String date);
    public String selectDangerAge(String date);
    public List<CoronaWeeksVO> selectRegionalCoronaTwoWeeks(String region, String date);
    public List<CoronaVaccineWeeksVO> selectRegionalCoronaVaccineTwoWeeks(String region, String date);
    public List<CoronaVaccineWeeksVO> selectVaccineInfo(String date);
}
