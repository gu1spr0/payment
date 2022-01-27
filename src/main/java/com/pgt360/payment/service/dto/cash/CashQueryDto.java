package com.pgt360.payment.service.dto.cash;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class CashQueryDto {
    private long id;
    private Integer numberCash;
    /*private Long commerceId;
    private Long deviceId;*/
    private Date createdDate;
    private Integer createdBy;
    private Date deletedDate;
    private Integer deletedBy;
    private Date lastModifiedDate;
    private Integer lastModifiedBy;
    private String state;
}
