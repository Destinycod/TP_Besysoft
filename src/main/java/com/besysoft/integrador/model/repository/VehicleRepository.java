package com.besysoft.integrador.model.repository;

import com.besysoft.integrador.model.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {

    @Query("select v from Vehicle v where v.patent=?1")
    public Vehicle findByPatent(String email);

}
