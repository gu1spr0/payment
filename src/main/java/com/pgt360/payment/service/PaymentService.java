package com.pgt360.payment.service;

import com.pgt360.payment.service.dto.payment.ResponseDto;

public interface PaymentService {
    ResponseDto payChipSingleCommerce(Double pAmount);
    ResponseDto payChipMultiCommerce(Double pAmount, Integer pCommerceId);
    ResponseDto payContactlessSingleCommerce(Double pAmount);
    ResponseDto payContactlessMultiCommerce(Double pAmount, Integer pCommerceId);
    ResponseDto cancelTransactionSingleCommerce(String pTransaction);
    ResponseDto cancelTransactionMultiCommerce(String pTransaction, Integer pCommerceId);
    ResponseDto closeSingleCommerce(Integer pConfirm);
    ResponseDto closeMultiCommerce(Integer pConfirm, Integer pCommerceId);
    ResponseDto initDevice(Integer pCommerceId, Integer pConfirm);
}
