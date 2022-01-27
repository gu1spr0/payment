package com.pgt360.payment.model.entity;

import com.pgt360.payment.model.entity.base.BaseConfigurationEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "pg_flujos")
public class Flow extends BaseConfigurationEntity {
    @NotNull(message = "El código de flujo no puede ser nulo")
    @Column(name = "codigo_flujo")
    private int codeFlow;

    @NotNull(message = "La descripción del flujo no puede ser nulo")
    @Column(name = "descripcion", length = 40)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_caja")
    private Cash cash;
}
