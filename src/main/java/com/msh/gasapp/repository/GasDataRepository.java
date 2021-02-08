package com.msh.gasapp.repository;

import com.msh.gasapp.model.Company;
import com.msh.gasapp.model.GasData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GasDataRepository extends JpaRepository<GasData, Integer> {
    List<GasData> findByCompany(Company company);
}
