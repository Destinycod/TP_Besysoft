package com.besysoft.integrador.model.service.implementations;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.domain.Client;
import com.besysoft.integrador.model.domain.Vehicle;
import com.besysoft.integrador.model.repository.ClientRepository;
import com.besysoft.integrador.model.service.interfaces.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository repository;

    public ClientServiceImpl(ClientRepository repository){
        this.repository = repository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Client> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Client findByEmail(String email) throws EntityNotFoundException{
        return this.repository.findByEmail(email);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Client> findById(Long id){
        return this.repository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Client save(Client client) throws BadRequestException {
        if(this.repository.findByEmail(client.getEmail()) != null ){
            throw new BadRequestException(
                    String.format("The client %s already exist", client.getEmail())
            );
        }
        return this.repository.save(client);
    }

    @Override
    @Transactional(readOnly = false)
    public Client update(Client client) throws EntityNotFoundException, BadRequestException {
        return this.repository.save(client);
    }

    @Override
    @Transactional(readOnly = false)
    public boolean partialUpdate(Long id, String key, Vehicle value) throws EntityNotFoundException {
        Optional<Client> optional = repository.findById(id);
        if (optional.isPresent()) {
            Client client = optional.get();

            /*if (key.equalsIgnoreCase("email")) {
                client.setEmail(value);
            }
            if (key.equalsIgnoreCase("landlinePhone")) {
                client.setLandlinePhone(value);
            }*/
            if (key.equalsIgnoreCase("vehicles")) {
                client.getVehicles().add(value);
            }

            repository.save(client);
            return true;
        } else {
            throw new EntityNotFoundException("RESOURCE_NOT_FOUND");
        }
    }

    @Override
    @Transactional(readOnly = false)
    public void deleteById(Long id) throws EntityNotFoundException {
        this.repository.deleteById(id);
    }
}
