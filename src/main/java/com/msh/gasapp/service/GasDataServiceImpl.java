package com.msh.gasapp.service;

import com.msh.gasapp.dto.DailyConsumptionDto;
import com.msh.gasapp.model.Employee;
import com.msh.gasapp.model.GasData;
import com.msh.gasapp.repository.EmployeeRepository;
import com.msh.gasapp.repository.GasDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.*;

@Service
public class GasDataServiceImpl implements GasDataService {

    private EmployeeRepository employeeRepository;
    private GasDataRepository gasDataRepository;

    @Autowired
    public GasDataServiceImpl(EmployeeRepository employeeRepository, GasDataRepository gasDataRepository) {
        this.employeeRepository = employeeRepository;
        this.gasDataRepository = gasDataRepository;
    }

    @Override
    public List<DailyConsumptionDto> getGasConsumptionByDays(String username) {

        Employee employee = employeeRepository.findByUsername(username);

        List<GasData> allCompanyGasData = gasDataRepository.findByCompany(employee.getCompany());

        return convertGasDataToDailyConsumption(allCompanyGasData);
    }

    private List<DailyConsumptionDto> convertGasDataToDailyConsumption(List<GasData> allCompanyGasData) {
        Map<String, Integer> dailyMap = createMapFromGasData(allCompanyGasData);

        return createDailyConsumptionDtoFromMap(dailyMap);
    }

    private List<DailyConsumptionDto> createDailyConsumptionDtoFromMap(Map<String, Integer> dailyMap) {
        List<DailyConsumptionDto> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : dailyMap.entrySet()) {
            list.add(new DailyConsumptionDto(entry.getKey(), entry.getValue()));
        }

        sortListByDate(list);

        return list;
    }

    private void sortListByDate(List<DailyConsumptionDto> list) {
        Comparator<DailyConsumptionDto> comparator = Comparator.comparing(DailyConsumptionDto::getDate);
        list.sort(comparator);
    }

    private Map<String, Integer> createMapFromGasData(List<GasData> gasData) {
        Map<String, Integer> dailyMap = new HashMap<>();
        for (GasData gasDataUnit : gasData) {
            Date date = new Date(gasDataUnit.getTimestamp().getTime());
            if (dailyMap.containsKey(date.toString())) {
                int valueBeforeAddition = dailyMap.get(date.toString());
                dailyMap.replace(date.toString(), valueBeforeAddition+gasDataUnit.getValue());
            } else {
                dailyMap.put(date.toString(), gasDataUnit.getValue());
            }
        }
        return dailyMap;
    }
}
