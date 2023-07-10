package com.besysoft.integrador.model.service.implementations;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.domain.Vehicle;
import com.besysoft.integrador.model.repository.VehicleRepository;
import com.besysoft.integrador.model.service.interfaces.VehicleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository repository;

    public VehicleServiceImpl(VehicleRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Vehicle> findAll() {
        return this.repository.findAll();
    }

    @Override
    public Optional<Vehicle> findById(Long id) {
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findByPatent(String patent) throws EntityNotFoundException {
        return this.repository.findByPatent(patent);
    }

    @Override
    @Transactional(readOnly = false)
    public Vehicle save(Vehicle vehicle) throws BadRequestException{
        if(this.repository.findByPatent(vehicle.getPatent()) != null) {
            throw new BadRequestException(
                    String.format("The vehicle %s already exist", vehicle.getPatent())
            );
        }
        return this.repository.save(vehicle);
    }

    @Override
    @Transactional(readOnly = false)
    public Vehicle update(Vehicle vehicle) throws EntityNotFoundException, BadRequestException {
        return this.repository.save(vehicle);
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Long id) throws EntityNotFoundException{
        this.repository.deleteById(id);
    }
}
