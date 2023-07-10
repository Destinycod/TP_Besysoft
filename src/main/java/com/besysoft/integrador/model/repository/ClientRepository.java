package com.besysoft.integrador.model.repository;

import com.besysoft.integrador.model.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("select c from Client c where c.email=?1")
    public Client findByEmail(String email);

}
