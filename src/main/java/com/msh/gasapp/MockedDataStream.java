package com.msh.gasapp;

import com.msh.gasapp.model.Company;
import com.msh.gasapp.model.GasData;
import com.msh.gasapp.repository.CompanyRepository;
import com.msh.gasapp.repository.GasDataRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Slf4j
@Configuration
public class MockedDataStream {

    private CompanyRepository companyRepository;
    private GasDataRepository gasDataRepository;

    @Autowired
    public MockedDataStream(CompanyRepository companyRepository, GasDataRepository gasDataRepository) {
        this.companyRepository = companyRepository;
        this.gasDataRepository = gasDataRepository;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void simulateGasDataStream() {
        while (true) {
            try {
                seedGasData();
                log.info("New Gas Data has been added...");
                Thread.sleep(3_600_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Transactional
    private void seedGasData() {
        List<Company> companies = companyRepository.findAll();

        for (Company company : companies) {
            GasData tempData = new GasData(new Timestamp(System.currentTimeMillis()), (int) ((Math.random() * (100 - 1)) + 1));
            tempData.setCompany(company);
            gasDataRepository.saveAndFlush(tempData);
        }
    }
}
