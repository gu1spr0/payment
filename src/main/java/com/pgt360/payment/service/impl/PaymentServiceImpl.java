package com.pgt360.payment.service.impl;

import com.pgt360.payment.client.handler.NettyHandlerIn;
import com.pgt360.payment.exception.Message;
import com.pgt360.payment.exception.MessageDescription;
import com.pgt360.payment.model.entity.Cash;
import com.pgt360.payment.model.entity.Flow;
import com.pgt360.payment.service.CashService;
import com.pgt360.payment.service.FlowService;
import com.pgt360.payment.service.PaymentService;
import com.pgt360.payment.service.dto.cash.CashQueryDto;
import com.pgt360.payment.service.dto.flow.FlowAddDto;
import com.pgt360.payment.service.dto.flow.FlowQueryDto;
import com.pgt360.payment.service.dto.payment.ResponseDto;
import com.pgt360.payment.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PaymentServiceImpl implements PaymentService {
    private final FlowService flowService;
    private final CashService cashService;
    public PaymentServiceImpl(
            FlowService flowService,
            CashService cashService){
        this.flowService = flowService;
        this.cashService = cashService;
    }
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
    public ResponseDto initDevice(Integer pCommerceId, Integer pConfirm) {
        log.info("Inicialización de Pos");
        if(pConfirm != 1 && pConfirm != null) {
            log.error("Inicialización no autorizada");
        } else {
            if(pCommerceId == null){
                log.error("Id comercio nulo");
            }else{
                //String hex = "02001736303030303030303030313030323030300321";
                //String send = NettyUtil.bytesToHex(hex.getBytes());
                Flow vFlow = new Flow();
                vFlow.setCodeFlow(1);
                vFlow.setDescription(Constants.FLOW_INIT);

                CashQueryDto vCashQueryDto = this.cashService.getCashById(pCommerceId);
                Cash vCash = new Cash();
                BeanUtils.copyProperties(vCashQueryDto,vCash);
                vFlow.setCash(vCash);

                FlowAddDto vFlowAddDto = new FlowAddDto();
                BeanUtils.copyProperties(vFlow, vFlowAddDto);

                FlowQueryDto vFlowQueryDto = this.flowService.addFlow(vFlowAddDto);
                NettyHandlerIn.sendMessage(vFlowQueryDto);
            }
        }
        ResponseDto responseDto = new ResponseDto();
        responseDto.setNombre("Exito");
        return responseDto;
    }
}
