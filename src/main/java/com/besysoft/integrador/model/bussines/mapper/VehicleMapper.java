package com.besysoft.integrador.model.bussines.mapper;

import com.besysoft.integrador.model.bussines.dto.VehicleDTO;
import com.besysoft.integrador.model.domain.Vehicle;

public class VehicleMapper {

    public static Vehicle mapToEntity(VehicleDTO dto){
        Vehicle vehicle = new Vehicle();
        vehicle.setId(vehicle.getId());
        vehicle.setYear(dto.getYear());
        vehicle.setBrand(dto.getBrand());
        vehicle.setModel(dto.getModel());
        vehicle.setColor(dto.getColor());
        vehicle.setPatent(dto.getPatent());
        vehicle.setClients(dto.getClients());

        return vehicle;
    }

    public static VehicleDTO mapToDto(Vehicle entity){
        VehicleDTO dto = new VehicleDTO();
        dto.setId(entity.getId());
        dto.setYear(entity.getYear());
        dto.setBrand(entity.getBrand());
        dto.setModel(entity.getModel());
        dto.setColor(entity.getColor());
        dto.setPatent(entity.getPatent());
        dto.setClients(entity.getClients());

        return dto;
    }
}
