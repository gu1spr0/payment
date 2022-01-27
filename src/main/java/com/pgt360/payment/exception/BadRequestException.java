package com.pgt360.payment.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends RuntimeException{
    @Getter
    private String code;

    public BadRequestException(String pCode){
        super("Error en la solicitud");
        this.code = code;
    }
    public BadRequestException(String pCode, String pMessage){
        super(pMessage);
        this.code = pCode;
    }

}
