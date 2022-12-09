package com.developer.api;

import com.developer.dto.AuthRequest;
import com.developer.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomController {

    @Autowired
    private JwtUtil jwtUtil ;

    @Autowired
    private AuthenticationManager authenticationManager ;

    @GetMapping("/")
    public String welcome()
    {
        return "welcome to java developer !! ";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception
    {
        try {


        // validate username and password corect then genarate Token
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authRequest.getUserName() ,authRequest.getPassword())
        );}catch (Exception ex)
        {
            throw new Exception("invalid username and password ");
        }
       return jwtUtil.generateToken(authRequest.getUserName());
    }
}
