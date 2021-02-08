package com.msh.gasapp.repository;

import com.msh.gasapp.model.GasData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="gasdata")
public interface GasDataRepository extends JpaRepository<GasData, Integer> {
}
