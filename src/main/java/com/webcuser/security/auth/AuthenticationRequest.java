package com.webcuser.security.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Data
public class AuthenticationRequest {
    private String firstname;
    private String lastname;
    private String email;
    private String password;

}
