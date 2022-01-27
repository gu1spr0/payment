package com.pgt360.payment.service.impl;

import com.google.common.base.Strings;
import com.pgt360.payment.exception.Message;
import com.pgt360.payment.exception.MessageDescription;
import com.pgt360.payment.model.entity.Flow;
import com.pgt360.payment.model.repository.FlowRepository;
import com.pgt360.payment.service.FlowService;
import com.pgt360.payment.service.dto.flow.FlowAddDto;
import com.pgt360.payment.service.dto.flow.FlowQueryDto;
import com.pgt360.payment.service.dto.flow.FlowUpdateDto;
import com.pgt360.payment.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FlowServiceImpl implements FlowService {
    private final FlowRepository flowRepository;
    Logger logger = LoggerFactory.getLogger(FlowServiceImpl.class);
    public FlowServiceImpl(FlowRepository flowRepository){
        this.flowRepository = flowRepository;
    }
    @Override
    public List<FlowQueryDto> getAllFlowByState(String pState) {
        if(Strings.isNullOrEmpty(pState)){
            Object[] obj = {pState};
            throw Message.GetBadRequest(MessageDescription.stateNotValid, obj);
        }
        List<Flow> vFlowList = this.flowRepository.getFlowsByState(pState);
        List<FlowQueryDto> vFlowQueryDtoList = new ArrayList<>();
        if(vFlowList != null){
            for(Flow vFlow : vFlowList){
                FlowQueryDto vFlowQueryDto = new FlowQueryDto();
                BeanUtils.copyProperties(vFlow, vFlowQueryDto);
                vFlowQueryDtoList.add(vFlowQueryDto);
            }
        }
        return vFlowQueryDtoList;
    }

    @Override
    public FlowQueryDto addFlow(FlowAddDto pFlowAddDto) {
        if(pFlowAddDto==null){
            Object[] obj = { "Objeto Flujo" };
            throw Message.GetBadRequest(MessageDescription.objectNull, obj);
        }
        Flow vFlow = new Flow();
        BeanUtils.copyProperties(pFlowAddDto, vFlow);
        Flow vNewFlow = this.flowRepository.save(vFlow);
        FlowQueryDto vFlowQueryDto = new FlowQueryDto();
        BeanUtils.copyProperties(vNewFlow, vFlowQueryDto);
        return vFlowQueryDto;
    }

    @Override
    public FlowQueryDto getFlowById(long pFlowId) {
        Flow vFlow = this.flowRepository.getFlowByIdAndState(pFlowId, Constants.STATE_ACTIVE).orElse(null);
        if(vFlow == null){
            Object[] obj = { "Objeto Flujo" };
            throw Message.GetBadRequest(MessageDescription.objectNull, obj);
        }
        FlowQueryDto vFlowQueryDto = new FlowQueryDto();
        BeanUtils.copyProperties(vFlow, vFlowQueryDto);
        return vFlowQueryDto;
    }

    @Override
    public FlowQueryDto updateFlowById(long pFlowId, FlowUpdateDto pFlowUpdateDto) {
        if((Long)pFlowId == null){
            Object[] obj = { "id Flujo" };
            throw Message.GetBadRequest(MessageDescription.validacionCampoVacioNulo, obj);
        }
        if(pFlowUpdateDto == null){
            Object[] obj = { "Objeto request Flujo" };
            throw Message.GetBadRequest(MessageDescription.objectNull, obj);
        }
        Flow vFlow = this.flowRepository.getFlowByIdAndState(pFlowId, Constants.STATE_ACTIVE).orElse(null);
        if(vFlow == null){
            Object[] obj = { "Objeto consulta Flujo" };
            throw Message.GetBadRequest(MessageDescription.objectNull, obj);
        }
        BeanUtils.copyProperties(pFlowUpdateDto, vFlow);
        Flow vNewFlow = this.flowRepository.save(vFlow);
        FlowQueryDto vFlowQueryDto = new FlowQueryDto();
        BeanUtils.copyProperties(vNewFlow,vFlowQueryDto);
        return vFlowQueryDto;
    }
}
