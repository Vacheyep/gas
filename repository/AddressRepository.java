package com.example.gas.repository;

import com.example.gas.model.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {
    boolean existsByCityAndStreet(String city,String street);
    Optional<Address> findAddressByCityAndStreet(String city,String street);

}
