package com.miniproject.absenhrweb.service;

import com.miniproject.absenhrweb.client.AuthClient;
import com.miniproject.absenhrweb.dto.request.LoginRequestDto;
import com.miniproject.absenhrweb.security.JwtUtil;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final AuthClient authClient;

    public LoginService(AuthClient authClient) {
        this.authClient = authClient;
    }

    public String login(LoginRequestDto request,
                        HttpSession session) {

        String token = authClient.login(request);

        session.setAttribute("TOKEN", token);
        String username = JwtUtil.extractUsername(token);

        String role = JwtUtil.extractRole(token);

        session.setAttribute("ROLE", role);
        session.setAttribute("USERNAME", username);


        return role;
    }

    public void logout(HttpSession session) {
        session.invalidate();
    }

}