package com.pgt360.payment.service.dto.flow;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
public class FlowQueryDto {
    private long id;
    private int codeFlow;
    private String description;
    private Long cash;
    private Date createdDate;
    private int createdBy;
    private Date deletedDate;
    private int deletedBy;
    private Date lastModifiedDate;
    private int lastModifiedBy;
    private String state;
}
