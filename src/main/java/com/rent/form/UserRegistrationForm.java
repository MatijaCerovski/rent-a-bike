package com.rent.form;

import com.rent.validation.PasswordMatches;
import com.rent.validation.ValidEmail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Matija on 5.6.2017..
 */
@Repository
@Data @AllArgsConstructor @NoArgsConstructor
@PasswordMatches
public class UserRegistrationForm {

    @NotNull(message = "First name is required")
    @NotEmpty(message = "First name is required")
    @Size(max=40)
    private String firstName;

    @NotNull(message = "Last name is required")
    @NotEmpty(message = "Last name is required")
    @Size(max=40)
    private String lastName;

    @NotNull(message = "Phone number is required")
    @NotEmpty(message = "Phone number is required")
    @Size(max=15)
    private String phoneNumber;

    @NotNull(message = "Email is required")
    @NotEmpty(message = "Email is required")
    @Size(max=254)
    @ValidEmail(message = "Please enter a valid email address")
    private String email;

    @NotNull(message = "Username is required")
    @NotEmpty(message = "Username is required")
    @Size(max=45)
    private String username;

    @NotNull(message = "Password is required")
    @NotEmpty(message = "Password is required")
    @Size(max=60)
    private String password;

    @NotNull(message = " field is required")
    @NotEmpty(message = " field is required")
    @Size(max=60)
    private String matchingPassword;

}
