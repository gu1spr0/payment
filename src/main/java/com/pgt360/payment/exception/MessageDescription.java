package com.pgt360.payment.exception;

public enum MessageDescription {
    //General 0-50
    stateNullOrEmpty,
    stateNotValid,
    validacionCampoVacioNulo,
    tokenNullOrEmpty,
    objectNull,
    PropertyNullOrEmpty,
    DataEmptyOrNull,

    // Entitys 101-150
    repeated,
    notExists,
    EntityDuplicated,

    // contraseñas  251-300
    ContraseniaIncorrecta,

    // Usuarios 301-350
    UsernameNoEncontrado,
    UsernameDuplicado,
    UserWithoutRoles,
    UserWithoutResources,
    UserWithoutPermissions,
    UserAccessDenied,

    //File
    Base64NotValid,
    Base64Null,
    Base64Int,
    Base64DatosError
}
