package com.pgt360.payment.model.entity;

import com.pgt360.payment.model.entity.base.BaseConfigurationEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "pg_comercios")
public class Commerce extends BaseConfigurationEntity {

    @NotNull(message = "La razon social no puede ser nulo")
    @Column(name = "razon_social", length = 40)
    private String socialReason;

    @OneToMany(mappedBy = "commerce",fetch = FetchType.LAZY)
    private List<Cash> cashList;
}
