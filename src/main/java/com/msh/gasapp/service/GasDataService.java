package com.msh.gasapp.service;

import com.msh.gasapp.dto.ReaderDailySummaryDto;

import java.util.List;

public interface GasDataService {
    List<ReaderDailySummaryDto> getDailyGasDataForAllReaders();
}
