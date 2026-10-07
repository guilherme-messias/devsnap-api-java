package br.com.guilhermemessias.devsnap.modules.user.controllers;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CredentialsUserDTO {
    private String username;
    private String password;
}
