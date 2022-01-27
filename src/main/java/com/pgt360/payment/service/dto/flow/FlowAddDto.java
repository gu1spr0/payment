package com.pgt360.payment.service.dto.flow;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FlowAddDto {
    private int codeFlow;
    private String description;
    private Long cash;
}
