package com.pgt360.payment.model.entity;

import com.pgt360.payment.model.entity.base.BaseConfigurationEntity;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@Entity
@Table(name = "pg_cajas")
public class Cash extends BaseConfigurationEntity {
    @NotNull(message = "El número de caja no puede ser nulo")
    @Column(name = "numero_caja")
    private int numberCash;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_comercio")
    private Commerce commerce;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_dispositivo", referencedColumnName = "id")
    private Device device;*/

    @OneToMany(mappedBy = "cash",fetch = FetchType.LAZY)
    private List<Flow> flowList;
}
