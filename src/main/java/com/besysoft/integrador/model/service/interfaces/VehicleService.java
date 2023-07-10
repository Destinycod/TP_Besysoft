package com.besysoft.integrador.model.service.interfaces;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.domain.Vehicle;

import java.util.List;
import java.util.Optional;

public interface VehicleService {
    public List<Vehicle> findAll();
    public Optional<Vehicle> findById(Long id);
    public Vehicle findByPatent(String patent) throws EntityNotFoundException;
    public Vehicle save(Vehicle vehicle) throws BadRequestException;
    public Vehicle update(Vehicle vehicle) throws EntityNotFoundException, BadRequestException;
    public void deleteById(Long id) throws EntityNotFoundException;
}
