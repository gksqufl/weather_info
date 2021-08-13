package com.weather.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import com.weather.service.RegionalInfoService;
import com.weather.vo.CoronaInfoVO;
import com.weather.vo.CoronaSidoInfoVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegionalAPIController {
    @Autowired
    RegionalInfoService service;
    @GetMapping("/api/regional")
    public Map<String, Object> getRegionalInfo(
        @RequestParam String region,
        @RequestParam @Nullable String date
    ) {
        Map<String, Object> resultMap = new LinkedHashMap<String, Object>();
        if(region == null || region.equals("전국")) {
                if(date == null) {
                Date now = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = formatter.format(now);
            }
            CoronaInfoVO vo = service.selectCoronaInfoRegionTotal(date);
            resultMap.put("data", vo);
            return resultMap;
        }
        if(date == null) {
            Date now = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = formatter.format(now);
        }

        CoronaSidoInfoVO vo = service.selectRegionalCoronaInfo(region, date);
        resultMap.put("data", vo);

        return resultMap;
    }
}
