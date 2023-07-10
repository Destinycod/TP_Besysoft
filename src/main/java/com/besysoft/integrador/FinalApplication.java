package com.besysoft.integrador;

import com.besysoft.integrador.model.domain.*;
import com.besysoft.integrador.model.repository.ClientRepository;
import com.besysoft.integrador.model.repository.VehicleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FinalApplication {
    public static void main(String[] args) {
        SpringApplication.run(FinalApplication.class, args);
    }

    @Bean
    public CommandLineRunner init(
            ClientRepository repository,
            VehicleRepository vehicleRepository
        ) {
        return (args) -> {
            System.out.println("Anda");
            Address address = new Address();
            address.setCity("Los Angeles");
            address.setDepartment("Dept A1");
            address.setCodeZip("CodeZip123");
            address.setFloor("Floor 0");
            address.setNumber("234");
            address.setStreet("Siempre Viva");

            PersonalData homero = new PersonalData();
            homero.setName("Homero");
            homero.setLastName("Simpson");
            homero.setCellphone("1546345");

            Client clientHomero = new Client();
            clientHomero.setEmail("homero@gmail.com");
            clientHomero.setLandlinePhone("1125465852");
            clientHomero.setAddress(address);
            clientHomero.setPersonalData(homero);

            repository.save(clientHomero);

            PersonalData marge = new PersonalData();
            marge.setName("Marge");
            marge.setLastName("Simpson");
            marge.setCellphone("1986345");

            Client clientMarge = new Client();
            clientMarge.setEmail("marge@gmail.com");
            clientMarge.setLandlinePhone("1125465852");
            clientMarge.setAddress(address);
            clientMarge.setPersonalData(marge);

            repository.save(clientMarge);

            Vehicle p208 = new Vehicle();
            p208.setPatent("AB123CD");
            p208.setBrand("Peugeot");
            p208.setModel("208");
            p208.setColor("Gray");
            p208.setYear(2015);
            vehicleRepository.save(p208);

            clientHomero.getVehicles().add(p208);
            repository.save(clientHomero);

            clientMarge.getVehicles().add(p208);

            Vehicle c4 = new Vehicle();
            c4.setPatent("AC753CD");
            c4.setBrand("Citroen");
            c4.setModel("C4");
            c4.setColor("Black");
            c4.setYear(2018);
            vehicleRepository.save(c4);

            clientMarge.getVehicles().add(c4);
            repository.save(clientMarge);

        };
    }
}

/* FIND ALL
    {
        "id": 1,
        "email": "homero@gmail.com",
        "landlinePhone": "1125465852",
        "codeZip": "CodeZip123",
        "street": "Siempre Viva",
        "number": "234",
        "department": "Dept A1",
        "floor": "Floor 0",
        "city": "Los Angeles",
        "name": "Homero",
        "lastName": "Simpson",
        "cellphone": "1546345"
    }
*/

/* POST
    {
        "email": "lisa@gmail.com",
        "landlinePhone": "1125465852",
        "vehicles": [],
        "codeZip": "CodeZip123",
        "street": "Siempre Viva",
        "number": "234",
        "department": "Dept A1",
        "floor": "Floor 0",
        "city": "Los Angeles",
        "name": "Lisa",
        "lastName": "Simpson",
        "cellphone": "2589635"
    }
 */
/*
Validar la existencia de Vehículo por patente.
Si existe Vehículo se validan los datos del Cliente.
Si no existe Vehículo se valida Cliente por e-mail.
Si existe Cliente, se vincula el Vehículo al cliente. LO IDEAL SERIA HACER PATCH, PARA ACTUALIZAR. EN REPO UPDATE VEHICLE LIST
Si no existe Cliente ni Vehículo, se registran a ambos.
*/

//TODO
// REPASAR POLIMORFISMO, VER DONDE SE PUEDE APLICAR Y ANOTAR SU USO EN ESTE PROYECTO, clases abstractas e interfaces
// UTILIZAR PATRONES
// CREAR REPOSITORY
// CREAR SERVICE
// CREAR CONTROLLER
// AGREGAR EXCEPCIONES --
// CREAR DTO Y MAPPERS
// AGREGAR EN CADA DTO @NOARGSCONSTR, SETTER Y GETTER
// AGREGAR EN CADA DTO LAS VALIDACIONES
// REALIZAR LOS TEST DE REPO, SERVICE Y CONTROLLER
// AGREGAR SWAGGER
// TESTEAR TODAS LAS VALIDACIONES
// PLUS:
// AGREGAR LOGS
// AGREGAR REST TEMPLATE?
// BORRADO LOGICO


// HACER EL CONTROLLER DE WORK ORDER DETAIL Y PROBAR AGREGAR El @ExceptionHandler(NoSuchElementFoundException.class)