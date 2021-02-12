package com.msh.gasapp.repository;

import com.msh.gasapp.model.GasData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GasDataRepository extends JpaRepository<GasData, Integer> {
}
