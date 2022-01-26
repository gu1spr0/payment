package com.pgt360.payment.service.impl;

import com.pgt360.payment.client.config.NettyInitializer;
import com.pgt360.payment.client.handler.NettyHandlerIn;
import com.pgt360.payment.service.PaymentService;
import com.pgt360.payment.service.dto.payment.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {

    @Override
    public ResponseDto payChipSingleCommerce(Double pAmount) {
        return null;
    }

    @Override
    public ResponseDto payChipMultiCommerce(Double pAmount, Integer pCommerceId) {
        return null;
    }

    @Override
    public ResponseDto payContactlessSingleCommerce(Double pAmount) {
        return null;
    }

    @Override
    public ResponseDto payContactlessMultiCommerce(Double pAmount, Integer pCommerceId) {
        return null;
    }

    @Override
    public ResponseDto cancelTransactionSingleCommerce(String pTransaction) {
        return null;
    }

    @Override
    public ResponseDto cancelTransactionMultiCommerce(String pTransaction, Integer pCommerceId) {
        return null;
    }

    @Override
    public ResponseDto closeSingleCommerce(Integer pConfirm) {
        return null;
    }

    @Override
    public ResponseDto closeMultiCommerce(Integer pConfirm, Integer pCommerceId) {
        return null;
    }

    @Override
    public ResponseDto initDevice(int pConfirm) {
        log.info("Inicialización de Pos");
        if(pConfirm != 1) {
            log.info("Inicialización no autorizada");
        } else {
            //String hex = "02001736303030303030303030313030323030300321";
            //String send = NettyUtil.bytesToHex(hex.getBytes());
            NettyHandlerIn.sendMessage("1");
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNombre("Israel");
        return responseDto;
    }
}
