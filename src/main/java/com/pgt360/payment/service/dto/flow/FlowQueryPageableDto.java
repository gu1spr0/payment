package com.pgt360.payment.service.dto.flow;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class FlowQueryPageableDto {
    private List<FlowQueryDto> flowQueryDtoList;
    private long totalRows;
}
