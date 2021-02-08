package com.msh.gasapp.service;

import com.msh.gasapp.dto.DailyConsumptionDto;

import java.util.List;

public interface GasDataService {

    List<DailyConsumptionDto> getGasConsumptionByDays(String username);
}
