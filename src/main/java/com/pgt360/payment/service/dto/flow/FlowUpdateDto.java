package com.pgt360.payment.service.dto.flow;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowUpdateDto {
    private int codeFlow;
    private String description;
    private Long cash;
    private String state;
}
