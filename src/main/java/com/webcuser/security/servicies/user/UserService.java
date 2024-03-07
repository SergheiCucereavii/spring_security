package com.webcuser.security.servicies.user;

import com.webcuser.security.auth.AuthenticationResponse;
import com.webcuser.security.models.dto.RegisterAuthenticateDTO;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    AuthenticationResponse register(RegisterAuthenticateDTO request);
    AuthenticationResponse login(RegisterAuthenticateDTO request);
}
