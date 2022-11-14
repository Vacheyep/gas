package com.example.gas.controller;

import com.example.gas.model.dto.AddressDto;
import com.example.gas.model.entities.Address;
import com.example.gas.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("/addresses")
   
    public ResponseEntity<?> createAddress(@Valid @RequestBody AddressDto addressDto){
        Assert.notNull(addressDto,"Address is null ");
        AddressDto address = addressService.createAddress(addressDto);
        return ResponseEntity.ok().body(address);
    }
    @GetMapping
    public List<Address> getData() {
        return AddressService.getData();
    }
}
