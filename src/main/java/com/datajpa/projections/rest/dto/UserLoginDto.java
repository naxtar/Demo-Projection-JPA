package com.datajpa.projections.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
public class UserLoginDto implements Serializable {

    private static final long serialVersionUID = -518512373740338979L;

    private final String username;
    private final String password;
}
