package com.br.gabproject.simpleproject.model.mapper;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum RoleEnum {

    @JsonProperty("ADM")
    ADM,
    @JsonProperty("QA")
    QA,
    @JsonProperty("DEV")
    DEV

}
