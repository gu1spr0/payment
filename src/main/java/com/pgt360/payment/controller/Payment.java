package com.pgt360.payment.controller;

import com.pgt360.payment.service.PaymentService;
import com.pgt360.payment.service.dto.payment.ResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Authorization;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Api(description = "Endpoint para la gestión de pagos con dispositivo POS")
@RestController
@RequestMapping("/payments")
public class Payment {
    private final PaymentService paymentService;
    public Payment(PaymentService paymentService){
        this.paymentService = paymentService;
    }
    @ApiOperation(value = "Realizar pago con chip para comercio único", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/chip/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto payChipSingleCommerce(@PathVariable(value = "amount", required = true) Double amount){
        return this.paymentService.payChipSingleCommerce(amount);
    }

    @ApiOperation(value = "Realizar pago con chip multicomercio", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/chip/{amount}/{commerceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto payChipMultiCommerce(@PathVariable(value = "amount", required = true) Double amount,
                                          @PathVariable(value = "commerceId", required = true) Integer commerceId){
        return this.paymentService.payChipMultiCommerce(amount, commerceId);
    }

    @ApiOperation(value = "Realizar pago sin contacto para comercio único", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/ctl/{amount}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto payContactlessSingleCommerce(@PathVariable(value = "amount", required = true) Double amount){
        return this.paymentService.payContactlessSingleCommerce(amount);
    }

    @ApiOperation(value = "Realizar pago sin contacto para multicomercio", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/ctl/{amount}/{commerceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto payContactlessMultiCommerce(@PathVariable(value = "amount", required = true) Double amount,
                                                   @PathVariable(value = "commerceId", required = true) Integer commerceId){
        return this.paymentService.payContactlessMultiCommerce(amount, commerceId);
    }

    @ApiOperation(value = "Realizar anulación de transacción de comercio único", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/cancel/{transaction}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto cancelTransactionSingleCommerce(@PathVariable(value = "transaction", required = true) String transaction){
        return this.paymentService.cancelTransactionSingleCommerce(transaction);
    }

    @ApiOperation(value = "Realizar anulación de transacción multicomercio", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/cancel/{transaction}/{commerceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto cancelTransactionMultiCommerce(@PathVariable(value = "transaction", required = true) String transaction,
                                                      @PathVariable(value = "commerceId", required = true) Integer commerceId){
        return this.paymentService.cancelTransactionMultiCommerce(transaction, commerceId);
    }

    @ApiOperation(value = "Realizar cierre de comercio único", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/close/{confirm}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto closeSingleCommerce(@PathVariable(value = "confirm", required = true) Integer confirm){
        return this.paymentService.closeSingleCommerce(confirm);
    }

    @ApiOperation(value = "Realizar cierre de multicomercio", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/close/{confirm}/{commerceId}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto closeMultiCommerce(@PathVariable(value = "confirm", required = true) Integer confirm,
                                          @PathVariable(value = "commerceId", required = true) Integer commerceId){
        return this.paymentService.closeMultiCommerce(confirm, commerceId);
    }

    @ApiOperation(value = "Inicializar dispositivo", authorizations = @Authorization(value = "Bearer"))
    @GetMapping(path = "/init/{confirm}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseDto initDevice(@PathVariable(value = "confirm", required = true) Integer confirm){
        return this.paymentService.initDevice(confirm);
    }
}
