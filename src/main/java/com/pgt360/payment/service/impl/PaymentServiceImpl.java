package com.pgt360.payment.service.impl;

import com.pgt360.payment.netty.domain.ChannelRepository;
import com.pgt360.payment.service.PaymentService;
import com.pgt360.payment.service.dto.payment.ResponseDto;
import com.pgt360.payment.util.NettyUtil;
import io.netty.channel.ChannelHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseDto initDevice(Integer pConfirm) {
        log.info("Inicialización de Pos");
        if(pConfirm != 1) {
            log.info("Inicialización no autorizada");
        } else {
            String hex = "02001736303030303030303030313030323030300321";
            String send = NettyUtil.bytesToHex(hex.getBytes());
        }
        return new ResponseDto();
    }
}