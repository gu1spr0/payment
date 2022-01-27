package com.pgt360.payment.service;

import com.pgt360.payment.service.dto.cash.CashQueryDto;


public interface CashService {
    CashQueryDto getCashById(long pCashId);
}
