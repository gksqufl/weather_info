package com.weather.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.weather.mapper.CoronaInfoMapper;
import com.weather.vo.CoronaAgeInfoVO;
import com.weather.vo.CoronaInfoVO;
import com.weather.vo.CoronaSidoInfoVO;
import com.weather.vo.CoronaVaccineInfoVO;

import org.apache.ibatis.javassist.Loader.Simple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoronaInfoService {
    @Autowired
    CoronaInfoMapper mapper;

    public void insertCoronaInfo(CoronaInfoVO vo) {
        mapper.insertCoronaInfo(vo);
    }

    public CoronaInfoVO selectTodayCoronaInfo() {
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()) {
            // 현재 접속시간이 기준시간 (10시30분10초) 보다 이전일 때
            // 하루 이전 날짜로 변경.
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        CoronaInfoVO data = mapper.selectCoronaInfoByDate(dt);

        Integer accExamCnt = data.getAccExamCnt();
        Integer decideCnt = data.getDecideCnt();

        DecimalFormat dFormatter = new DecimalFormat("###,###");
        String strAccExamCnt = dFormatter.format(accExamCnt);
        String strDecideCnt = dFormatter.format(decideCnt);

        data.setStrAccExamCnt(strAccExamCnt);
        data.setStrDecideCnt(strDecideCnt);

        return data;
    }

    public void insertCoronaSidoInfo(CoronaSidoInfoVO vo) {
        mapper.insertCoronaSidoInfo(vo);
    }

    public List<CoronaSidoInfoVO> selectTodayCoronaSidoInfo() {
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 10);
        standard.set(Calendar.MINUTE, 30);
        standard.set(Calendar.SECOND, 10);

        if(now.getTimeInMillis() < standard.getTimeInMillis()) {
            // 현재 접속시간이 기준시간 (10시30분10초) 보다 이전일 때
            // 하루 이전 날짜로 변경.
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());

        return mapper.selectCoronaSidoInfo(dt);
    }

    public List<CoronaSidoInfoVO> selectCoronaSidoInfo(String date) {
        return mapper.selectCoronaSidoInfo(date);
    }

    public void insertCoronaAgeInfo(CoronaAgeInfoVO vo) {
        mapper.insertCoronaAge(vo);
    }

    public Map<String, Object> selectCoronaTodayAgeInfo() {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 16);
        standard.set(Calendar.MINUTE, 10);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()) {
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());
        
        resultMap.put("dt", dt);
        resultMap.put("data", mapper.selectCoronaAgeInfo(dt));
        
        return resultMap;
    }
    
    public List<CoronaAgeInfoVO> selectCoronaTodayGenInfo() {
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 16);
        standard.set(Calendar.MINUTE, 10);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()) {
            // 현재 접속시간이 기준시간 (10시30분10초) 보다 이전일 때
            // 하루 이전 날짜로 변경.
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());
        return mapper.selectCoronaGenInfo(dt);
    }

    public List<CoronaAgeInfoVO> selectCoronaAgeInfo(String date) {
        return mapper.selectCoronaAgeInfo(date);
    }
    public List<CoronaAgeInfoVO> selectCoronaGenInfo(String date) {
        return mapper.selectCoronaGenInfo(date);
    }
    
    public void insertCoronaVaccineInfo(CoronaVaccineInfoVO vo) {
        mapper.insertCoronaVaccineInfo(vo);
    }

    public List<CoronaVaccineInfoVO> selectTodayCoronaVaccineInfo() {
        Calendar now = Calendar.getInstance();
        Calendar standard = Calendar.getInstance();
        standard.set(Calendar.HOUR_OF_DAY, 11);
        standard.set(Calendar.MINUTE, 00);
        standard.set(Calendar.SECOND, 00);

        if(now.getTimeInMillis() < standard.getTimeInMillis()) {
            now.add(Calendar.DATE, -1);
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dt = formatter.format(now.getTime());
        return mapper.selectCoronaVaccineInfo(dt);
    }

    public List<CoronaVaccineInfoVO> selectCoronaVaccineInfo(String date) {
        return mapper.selectCoronaVaccineInfo(date);
    }
}
