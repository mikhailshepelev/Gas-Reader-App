package com.msh.gasapp;

import com.msh.gasapp.model.GasReader;
import com.msh.gasapp.model.GasData;
import com.msh.gasapp.repository.GasReaderRepository;
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

    private GasReaderRepository gasReaderRepository;
    private GasDataRepository gasDataRepository;

    @Autowired
    public MockedDataStream(GasReaderRepository gasReaderRepository, GasDataRepository gasDataRepository) {
        this.gasReaderRepository = gasReaderRepository;
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
        List<GasReader> readers = gasReaderRepository.findAll();

        for (GasReader gasReader : readers) {
            GasData tempData = new GasData(new Timestamp(System.currentTimeMillis()), (int) ((Math.random() * (100 - 1)) + 1));
            tempData.setGasReader(gasReader);
            gasDataRepository.saveAndFlush(tempData);
        }
    }
}
