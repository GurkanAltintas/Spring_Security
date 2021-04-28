package net.spring.security.login;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotNull
    private String username;

    @NotNull
    private String password;
}
