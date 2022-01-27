package com.pgt360.payment.service.dto.cash;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CashQueryPageableDto {
    private List<CashQueryDto> cashQueryDtoList;
    private long totalRows;
}
