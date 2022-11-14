package com.example.gas.repository;

import com.example.gas.model.entities.CheckStation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckStationRepository extends JpaRepository<CheckStation,Long> {
    boolean existsBySpecialCode(String specialCode);
}
