package com.besysoft.integrador.model.service.interfaces;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.domain.Client;
import com.besysoft.integrador.model.domain.Vehicle;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ClientService {

    public List<Client> findAll();
    public Client findByEmail(String email) throws EntityNotFoundException;
    public Optional<Client> findById(Long id);
    public Client save(Client client) throws BadRequestException;
    public Client update(Client client) throws EntityNotFoundException, BadRequestException;
    public boolean partialUpdate(Long id, String key, Vehicle value) throws EntityNotFoundException;
    public void deleteById(Long id) throws EntityNotFoundException;
}
