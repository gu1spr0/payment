package com.pgt360.payment.model.entity.base;

import com.pgt360.payment.util.Constants;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class BaseConfigurationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Identificador generado por la base de datos")
    @Column(name = "id")
    private Long id;

    @PastOrPresent(message = "La fecha de alta del registro debe ser actual")
    @NotNull(message = "La fecha de alta del registro no debe ser nula")
    @Column(name = "fecha_alta")
    @ApiModelProperty(notes = "Fecha de alta del registro en base de datos")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @NotNull(message = "El usuario que dió de alta el registro no debe ser nula")
    @Column(name = "usuario_alta")
    @ApiModelProperty(notes = "Usuario que dió de alta el registro")
    private Integer createdBy;

    @Column(name = "fecha_baja")
    @ApiModelProperty(notes = "Fecha de baja del registro en base de datos")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedDate;

    @Column(name = "usuario_baja")
    @ApiModelProperty(notes = "Usuario que dió de baja el registro")
    private Integer deletedBy;

    @ApiModelProperty(notes = "Fecha de última modificacón del registro")
    @Column(name = "fecha_modificacion", nullable = true)
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Column(name = "usuario_modificacion", nullable = true)
    @ApiModelProperty(notes = "Usuario que modificó por última vez el registro")
    private Integer lastModifiedBy;

    @NotNull(message = "El estado no puede ser nulo")
    @ApiModelProperty(notes = "Contiene el estado del regristro")
    @Column(name = "estado")
    private String state;

    @PrePersist
    public void prePersist() {
        Date now = new Date();
        if (createdDate == null) {
            createdDate = now;
            createdBy = 0;
            state = Constants.STATE_ACTIVE;
        }
    }

    @PreUpdate
    public void preUpdate(){
        //lastModifiedBy = Security.getUserOfAuthenticatedUser();
        lastModifiedBy = 0;
        lastModifiedDate = new Date();
        if  (deletedDate != null){
            deletedBy = 0;
            state = Constants.STATE_DELETED;
        }
    }
}
