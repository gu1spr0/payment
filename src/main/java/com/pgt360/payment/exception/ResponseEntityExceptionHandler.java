package com.pgt360.payment.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class ResponseEntityExceptionHandler extends org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler {
    String message = "";

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handelAllException(Exception pEx, WebRequest pRequest){
        ExceptionResponse vExceptionResponse = new ExceptionResponse("0", pEx.getMessage(), pRequest.getDescription(false));
        return new ResponseEntity(vExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFoundException.class)
    public final ResponseEntity<Object> handleServerNotFoundException(NotFoundException pEx, WebRequest pRequest){
        ExceptionResponse vExceptionResponse = new ExceptionResponse(pEx.getCode(), pEx.getMessage(), pEx.getStackTrace().toString());
        return new ResponseEntity(vExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<Object> handleServerBadRequestException(BadRequestException pEx, WebRequest pRequest){
        ExceptionResponse vExceptionResponse = new ExceptionResponse(pEx.getCode(), pEx.getMessage(), pEx.getStackTrace().toString());
        return new ResponseEntity(vExceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException pEx, HttpHeaders pHeaders, HttpStatus pStatus, WebRequest pRequest) {
        pEx.getBindingResult().getAllErrors().forEach(e -> {
            message += e.getDefaultMessage().toString() + "/n";
        });
        ExceptionResponse exceptionResponse = new ExceptionResponse(pEx.getParameter().toString(), message, pEx.getBindingResult().toString());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}
