package com.rent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matija on 5.6.2017..
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class UserRegistrationDto {

    @NotNull
    @NotEmpty
    @Size(max=40)
    private String firstName;

    @NotNull
    @NotEmpty
    @Size(max=40)
    private String lastName;

    @NotNull
    @NotEmpty
    @Size(max=15)
    private String number;

    @NotNull
    @NotEmpty
    @Size(max=254)
    private String email;

    @NotNull
    @NotEmpty
    @Size(max=45)
    private String username;

    @NotNull
    @NotEmpty
    @Size(max=60)
    private String password;

    @NotNull
    @NotEmpty
    @Size(max=60)
    private String matchingPassword;

}
