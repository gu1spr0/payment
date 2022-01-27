package com.pgt360.payment.model.entity;

import com.pgt360.payment.model.entity.base.BaseConfigurationEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "no_dominios_valores")
public class DomainValue extends BaseConfigurationEntity {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "dva_domcodigo")
    private Domain domain;

    @NotNull(message = "El codigo valor no puede ser nulo")
    @Column(name = "dva_codigo_valor", length = 100)
    private String codeValue;

    @Column(name = "dva_titulo_descripcion", length = 300)
    private String titleDescription;

    @Column(name = "dva_valor_caracter", length = 300)
    private String charValue;

    @Column(name = "dva_valor_numerico")
    private Long numericValue;

    @Column(name = "dva_valor_caracter_extra", length = 300)
    private String charValueExtra;

    @Column(name = "dva_valor_numerico_extra")
    private Long numericValueExtra;
}
