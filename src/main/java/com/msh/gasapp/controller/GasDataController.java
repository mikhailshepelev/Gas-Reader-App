package com.msh.gasapp.controller;

import com.msh.gasapp.dto.ReaderDailySummaryDto;
import com.msh.gasapp.service.GasDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class GasDataController {

    private GasDataService gasDataService;

    @Autowired
    public GasDataController(GasDataService gasDataService) {
        this.gasDataService = gasDataService;
    }

    @GetMapping("/gasdata")
    public List<ReaderDailySummaryDto> getDailyConsumption(){
        return gasDataService.getDailyGasDataForAllReaders();
    }
}
