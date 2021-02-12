package com.msh.gasapp.service;

import com.msh.gasapp.dto.DailyConsumptionDto;
import com.msh.gasapp.dto.ReaderDailySummaryDto;
import com.msh.gasapp.model.GasData;
import com.msh.gasapp.model.GasReader;
import com.msh.gasapp.repository.GasReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class GasDataServiceImpl implements GasDataService {

    private GasReaderRepository gasReaderRepository;

    @Autowired
    public GasDataServiceImpl(GasReaderRepository gasReaderRepository) {
        this.gasReaderRepository = gasReaderRepository;
    }

    @Override
    public List<ReaderDailySummaryDto> getDailyGasDataForAllReaders() {
        List<GasReader> gasReaders = gasReaderRepository.findAll();

        return convertAllReadersDataToDailyData(gasReaders);
    }

    private List<ReaderDailySummaryDto> convertAllReadersDataToDailyData(List<GasReader> gasReaders) {
        List<ReaderDailySummaryDto> dailyDataList = new ArrayList<>();

        for (GasReader reader : gasReaders) {
            dailyDataList.add(convertOneReaderDataToDailyData(reader));
        }

        return dailyDataList;
    }

    private ReaderDailySummaryDto convertOneReaderDataToDailyData(GasReader reader) {

        ReaderDailySummaryDto unit = new ReaderDailySummaryDto(reader.getName());

        List<DailyConsumptionDto> dailyConsumptionList = convertGasDataToDailyConsumption(reader.getGasData());
        sortListByDate(dailyConsumptionList);
        unit.setDailyConsumption(dailyConsumptionList);

        return unit;
    }

    private List<DailyConsumptionDto> convertGasDataToDailyConsumption(List<GasData> readerGasData) {
        Map<String, Integer> dailyMap = createMapFromGasData(readerGasData);

        return createDailyConsumptionDtoFromMap(dailyMap);
    }

    private Map<String, Integer> createMapFromGasData(List<GasData> gasData) {
        Map<String, Integer> dailyMap = new HashMap<>();
        for (GasData gasDataUnit : gasData) {
            String date = getStringRepresentationOfDate(gasDataUnit.getTimestamp());
            if (dailyMap.containsKey(date)) {
                int valueBeforeAddition = dailyMap.get(date);
                dailyMap.replace(date, valueBeforeAddition+gasDataUnit.getValue());
            } else {
                dailyMap.put(date, gasDataUnit.getValue());
            }
        }
        return dailyMap;
    }

    private static String getStringRepresentationOfDate(Timestamp date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return formatter.format(date);
    }

    private List<DailyConsumptionDto> createDailyConsumptionDtoFromMap(Map<String, Integer> dailyMap) {
        List<DailyConsumptionDto> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dailyMap.entrySet()) {
            list.add(new DailyConsumptionDto(entry.getKey(), entry.getValue()));
        }

        return list;
    }

    private void sortListByDate(List<DailyConsumptionDto> list) {
        Comparator<DailyConsumptionDto> comparator = Comparator.comparing(DailyConsumptionDto::getDate);
        list.sort(comparator);
    }
}
