package com.weather.vo;

import java.util.Date;

import lombok.Data;

@Data
public class CoronaInfoSidoVO {
    private Integer seq;
    private Date createDt;
    private Integer deathCnt;
    private Integer defCnt;
    private String gubun;
    private Integer incDec;
    private Integer isolClearCnt;
    private Integer isolingCnt;
    private Integer localOccCnt;
    private Integer overFlowCnt;

}
