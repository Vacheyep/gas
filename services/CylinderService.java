package com.example.gas.services;

import com.example.gas.model.entities.Cylinder;
import com.example.gas.model.entities.Owner;
import com.example.gas.model.dto.ValidateCylinderDto;
import com.example.gas.exceptions.DuplicateResourceException;
import com.example.gas.exceptions.ResourceNotFoundException;
import com.example.gas.model.mappers.AddressMapper;
import com.example.gas.model.mappers.CylinderMapper;
import com.example.gas.model.mappers.OwnerMapper;
import com.example.gas.repository.AddressRepository;
import com.example.gas.repository.CylinderRepository;
import com.example.gas.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CylinderService {
    private final CylinderMapper cylinderMapper;
    private final CylinderRepository cylinderRepository;
    private final OwnerMapper ownerMapper;
    private final OwnerRepository ownerRepository;
    private final AddressMapper addressMapper;
    private final AddressRepository addressRepository;

    @Autowired
    public CylinderService(CylinderMapper cylinderMapper, CylinderRepository cylinderRepository,
                           OwnerMapper ownerMapper, OwnerRepository ownerRepository,
                           AddressMapper addressMapper, AddressRepository addressRepository) {
        this.cylinderMapper = cylinderMapper;
        this.cylinderRepository = cylinderRepository;
        this.ownerMapper = ownerMapper;
        this.ownerRepository = ownerRepository;
        this.addressMapper = addressMapper;
        this.addressRepository = addressRepository;
    }

    public ValidateCylinderDto createCylinder(ValidateCylinderDto validateCylinderDto) {
        Optional<Owner> owner = this.ownerRepository.findOwnerByEmail(validateCylinderDto.getOwnerDto().getEmail());
        if (owner.isEmpty()){
            throw new ResourceNotFoundException("The user is not found ");
        }
        if(this.cylinderRepository.existsByCylinderNumber(validateCylinderDto.getCylinderNumber())){
            throw new DuplicateResourceException("cylinder with this number already exist");
        }
        Cylinder cylinder = this.cylinderMapper.toCylinder(validateCylinderDto);
        cylinder.setOwner(owner.get());
        return this.cylinderMapper.toValidateCylinderDto(this.cylinderRepository.save(cylinder));
    }

}

