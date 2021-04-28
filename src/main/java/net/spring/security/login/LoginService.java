package net.spring.security.login;

import lombok.RequiredArgsConstructor;
import net.spring.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    @Value("${security.jwt.secretKey}")
    private String secretKey;

    private final DaoAuthenticationProvider authenticationProvider;
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication authentication=new UsernamePasswordAuthenticationToken(
                loginRequest.getUsername(),loginRequest.getPassword());
        try{
            Authentication user = authenticationProvider.authenticate(authentication);
            String token= JwtUtil.generateToken(user, secretKey,7);
            return new LoginResponse(token);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
