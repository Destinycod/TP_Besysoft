package com.besysoft.integrador.controller.handlerController;

import com.besysoft.integrador.exceptions.BadRequestException;
import com.besysoft.integrador.exceptions.EntityNotFoundException;
import com.besysoft.integrador.model.bussines.dto.response.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice(annotations = RestController.class)
public class ApiControllerAdvice {

    /*
    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO exceptionHandler(MethodArgumentNotValidException ex){
        List<FieldError> errorList = ex.getBindingResult().getFieldErrors();
        Map<String, String> detail = new HashMap<>();
        errorList.forEach(e -> detail.put(e.getField(), e.getDefaultMessage()));
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                "Validaciones",
                detail
        );
    }

    /*@ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO isExist(EntityExistException ex){
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                null
        );
    }*/

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ExceptionDTO isBadRequest(BadRequestException ex){
        System.out.println("Se lanza el bad request de apicontroller");
        //List<FieldError> errorList = (List<FieldError>) ex.getCause();
        //Map<String, String> detail = new HashMap<>();
        //errorList.forEach(e -> detail.put(e.getField(), e.getDefaultMessage()));
        return new ExceptionDTO(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                (Map<String, String>) ex.getCause()
                //detail
        );
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDTO isExist(EntityNotFoundException ex){
        System.out.println("Se lanza el not found de apicontroller");
        return new ExceptionDTO(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                (Map<String, String>) ex.getCause()
        );
    }
}
