package com.pgt360.payment.service.impl;

import com.pgt360.payment.exception.Message;
import com.pgt360.payment.exception.MessageDescription;
import com.pgt360.payment.model.entity.Cash;
import com.pgt360.payment.model.repository.CashRepository;
import com.pgt360.payment.service.CashService;
import com.pgt360.payment.service.dto.cash.CashQueryDto;
import com.pgt360.payment.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CashServiceImpl implements CashService {
    private final CashRepository cashRepository;
    Logger logger = LoggerFactory.getLogger(CashServiceImpl.class);
    public CashServiceImpl(CashRepository cashRepository){
        this.cashRepository = cashRepository;
    }

    @Override
    public CashQueryDto getCashById(long pCashId) {
        Cash vCash = this.cashRepository.getCashByIdAndState(pCashId, Constants.STATE_ACTIVE).orElse(null);
        if(vCash == null){
            Object[] obj = { "Objeto Caja" };
            throw Message.GetBadRequest(MessageDescription.objectNull, obj);
        }
        CashQueryDto vCashQueryDto = new CashQueryDto();
        BeanUtils.copyProperties(vCash, vCashQueryDto);
        return vCashQueryDto;
    }
}
