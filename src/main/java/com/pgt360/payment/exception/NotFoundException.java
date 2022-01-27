package com.pgt360.payment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
    @Getter
    private String code;

    public NotFoundException(Long pId, String pEntity, String pCode){
        super("No se encontró resultados para la consulta de " + pEntity + " con el Id: " + pId);
        this.code = pCode;
    }

    public NotFoundException(String pCode, String pMessage) {
        super(pMessage);
        this.code = pCode;
    }
}
