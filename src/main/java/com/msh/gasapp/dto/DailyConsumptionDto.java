package com.msh.gasapp.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class DailyConsumptionDto {

    private String date;
    private int dailyConsumption;
}
