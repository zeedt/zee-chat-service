package com.zeed.zeechat.usermanagement.apimodel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter @Setter @NoArgsConstructor
public class UserSignupRequestModel {

    @NotBlank(message = "Username cannot be blank")
    private String username;

    @NotBlank(message = "Password cannot be blank")
    @Length(min = 6, max = 20, message = "Password must be between 6 to 20 characters")
    private String password;

    @NotBlank(message = "Firstname cannot be blank")
    private String firstName;

    @NotBlank(message = "Firstname cannot be blank")
    private String lastName;

    @Email(message = "Valid email address is required")
    private String email;

}
