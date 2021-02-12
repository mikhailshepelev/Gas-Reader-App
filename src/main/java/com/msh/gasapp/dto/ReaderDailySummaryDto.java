package com.msh.gasapp.dto;

import lombok.Data;

import java.util.List;

@Data
public class ReaderDailySummaryDto {

    private String readerName;
    private List<DailyConsumptionDto> dailyConsumption;

    public ReaderDailySummaryDto(String readerName) {
        this.readerName = readerName;
    }
}
