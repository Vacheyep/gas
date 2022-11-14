package com.example.gas.model.mappers;

import com.example.gas.model.dto.CheckCylinderDto;
import com.example.gas.model.dto.ValidateCylinderDto;
import com.example.gas.model.entities.Cylinder;
import org.springframework.stereotype.Component;

@Component
public class CylinderMapper {

    private final OwnerMapper ownerMapper;

    public CylinderMapper(OwnerMapper ownerMapper) {
        this.ownerMapper = ownerMapper;
    }

    public CheckCylinderDto toCheckCylinderDto(Cylinder cylinder){
        return new CheckCylinderDto(cylinder.getCarNumber(), cylinder.getCylinderNumber());
    }

    public Cylinder toCylinder(ValidateCylinderDto validateCylinderDto){
        return new Cylinder(validateCylinderDto.getCarNumber(), validateCylinderDto.getCylinderNumber(),
                validateCylinderDto.getVerificationDate(),ownerMapper.toOwner(validateCylinderDto.getOwnerDto()));
    }

    public ValidateCylinderDto toValidateCylinderDto(Cylinder cylinder){
        return new ValidateCylinderDto(cylinder.getCarNumber(), cylinder.getCylinderNumber(),
                cylinder.getVerificationDate(),ownerMapper.toOwnerDto(cylinder.getOwner()));
    }

}
