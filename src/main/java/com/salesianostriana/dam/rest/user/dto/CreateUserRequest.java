package com.salesianostriana.dam.rest.user.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Validated
public class CreateUserRequest {

    @NotBlank(message = "The username can't be empty")
    private String username;

    @NotBlank(message = "The password have to be min 8 characters")
    @Min(8)
    private String password;
    private String verifyPassword;
    private String avatar;
    private String fullName;


    private String email;

}
