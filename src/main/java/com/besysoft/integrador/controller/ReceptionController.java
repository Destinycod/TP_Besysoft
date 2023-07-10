package com.besysoft.integrador.controller;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.bussines.dto.ClientDTO;
import com.besysoft.integrador.model.bussines.dto.VehicleDTO;
import com.besysoft.integrador.model.bussines.mapper.ClientMapper;
import com.besysoft.integrador.model.bussines.mapper.VehicleMapper;
import com.besysoft.integrador.model.domain.Client;
import com.besysoft.integrador.model.domain.Vehicle;
import com.besysoft.integrador.model.service.interfaces.ClientService;
import com.besysoft.integrador.model.service.interfaces.VehicleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "receptions", produces = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ReceptionController {

    private final ClientService clientService;
    private final VehicleService vehicleService;

    @GetMapping("/{patent}")
    public ResponseEntity<?> findByPatent(@PathVariable String patent) throws EntityNotFoundException {
        if(this.vehicleService.findByPatent(patent) != null) {
            return new ResponseEntity<Vehicle>(this.vehicleService.findByPatent(patent), HttpStatus.OK);
        }
        throw new EntityNotFoundException(String.format("The patent %s does not exist", patent));
    }

    @GetMapping("/clientEmail")
    public ResponseEntity<?> findByEmail(@RequestParam String email) throws EntityNotFoundException {
        if(this.clientService.findByEmail(email) != null){
            return new ResponseEntity<Client>(this.clientService.findByEmail(email), HttpStatus.OK);
        }
        throw new EntityNotFoundException(String.format("The email %s does not exist", email));
    }

    @PostMapping("/clients")
    public ResponseEntity<?> save(@Valid @RequestBody ClientDTO client) throws BadRequestException {
        return new ResponseEntity<Client>(this.clientService.save(ClientMapper.mapToEntity(client)),
                HttpStatus.CREATED);
    }

    @PostMapping("/vehicles")
    public ResponseEntity<?> save(@Valid @RequestBody VehicleDTO vehicle) throws BadRequestException {
        return new ResponseEntity<Vehicle>(this.vehicleService.save(VehicleMapper.mapToEntity(vehicle)),
                HttpStatus.CREATED);
    }

    /*
    @RequestMapping(value = "/clients/{id}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> partialUpdate(
            @RequestBody Map<String, Object> updates,
            @PathVariable("id") Long id) {
        System.out.println("The updates: "+updates);
        //clientService.save(updates, id);
        return new ResponseEntity<Client>(this.clientService.save(updates, id), HttpStatus.OK);
        //return ResponseEntity.ok("resource updated");
    }*/
/*
    @PatchMapping("/{id}") //"/clients/{id}"
    public ResponseEntity<Boolean> partialUpdate(@PathVariable Long id,
        @RequestBody ClientUpdateDTO dto) throws EntityNotFoundException, Exception {
        // skipping validations for brevity
        if (dto.getOperation().equalsIgnoreCase("update")) {
            boolean result = clientService.partialUpdate(id, dto.getKey(), dto.getValue());
            return new ResponseEntity<>(result, HttpStatus.ACCEPTED);
        } else {
            throw new Exception("NOT_YET_IMPLEMENTED");
        }
    }*/


}
