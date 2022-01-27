package com.pgt360.payment.service;

import com.pgt360.payment.service.dto.flow.FlowAddDto;
import com.pgt360.payment.service.dto.flow.FlowQueryDto;
import com.pgt360.payment.service.dto.flow.FlowUpdateDto;

import java.util.List;

public interface FlowService {
    List<FlowQueryDto> getAllFlowByState(String pState);
    FlowQueryDto addFlow(FlowAddDto pFlowAddDto);
    FlowQueryDto getFlowById(long pFlowId);
    FlowQueryDto updateFlowById(long pFlowId, FlowUpdateDto pFlowUpdateDto);
}
