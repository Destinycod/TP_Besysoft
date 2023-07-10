package com.besysoft.integrador.model.bussines.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class ExceptionDTO {
    private int status;
    private String message;
    private Map<String, String> detail;
}
