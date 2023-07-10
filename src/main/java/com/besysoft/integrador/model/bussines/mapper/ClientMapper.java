package com.besysoft.integrador.model.bussines.mapper;

import com.besysoft.integrador.model.bussines.dto.ClientDTO;
import com.besysoft.integrador.model.domain.Address;
import com.besysoft.integrador.model.domain.Client;
import com.besysoft.integrador.model.domain.PersonalData;

public class ClientMapper {

    public static Client mapToEntity(ClientDTO dto){
        Client client = new Client();
        client.setId(client.getId());
        client.setEmail(dto.getEmail());
        client.setLandlinePhone(dto.getLandlinePhone());
        client.setVehicles(dto.getVehicles());

        client.setAddress(new Address(dto.getCodeZip(), dto.getStreet(),
                dto.getNumber(), dto.getDepartment(), dto.getFloor(), dto.getCity()));
        client.setPersonalData(new PersonalData(dto.getName(), dto.getLastName(),
                dto.getCellphone()));

        return client;
    }

    public static ClientDTO mapToDto(Client entity){
        ClientDTO dto = new ClientDTO();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setLandlinePhone(entity.getLandlinePhone());
        dto.setVehicles(entity.getVehicles());

        dto.setCodeZip(entity.getAddress().getCodeZip());
        dto.setStreet(entity.getAddress().getStreet());
        dto.setNumber(entity.getAddress().getNumber());
        dto.setDepartment(entity.getAddress().getDepartment());
        dto.setFloor(entity.getAddress().getFloor());
        dto.setCity(entity.getAddress().getCity());

        dto.setName(entity.getPersonalData().getName());
        dto.setLastName(entity.getPersonalData().getLastName());
        dto.setCellphone(entity.getPersonalData().getCellphone());

        return dto;
    }
}
