package com.example.gas.repository;

import com.example.gas.model.entities.Cylinder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CylinderRepository extends JpaRepository<Cylinder,Long> {
    boolean existsByCylinderNumber(String cylinderNumber);
}
