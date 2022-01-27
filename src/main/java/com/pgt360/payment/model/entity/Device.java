package com.pgt360.payment.model.entity;

import com.pgt360.payment.model.entity.base.BaseConfigurationEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "pg_dispositivos")
public class Device extends BaseConfigurationEntity {
    @NotNull(message = "El nombre de dispositivo no puede ser nulo")
    @Column(name = "nombre", length = 100)
    private String name;

    @NotNull(message = "La descripcion de modelo no puede ser nulo")
    @Column(name = "modelo", length = 60)
    private String model;

    @Column(name = "ip", length = 15)
    private String ip;

    @Column(name = "mpk")
    private int mpk;

    @Column(name = "pnr", length = 20)
    private String pnr;

    @NotNull(message = "El código de flujo no puede ser nulo")
    @Column(name = "id_terminal")
    private int terminalId;

    /*@OneToOne(mappedBy = "device")
    private Cash cash;*/

}
