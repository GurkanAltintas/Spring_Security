package net.spring.security.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Configuration
@EnableWebSecurity
public class Configure extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder1())
                .withUser("admin")
                .password(passwordEncoder1().encode("admin"))
                .authorities(List.of(new SimpleGrantedAuthority("ADMIN")))
        .and().withUser("user").password(passwordEncoder1().encode("user"))
                .authorities(List.of(new SimpleGrantedAuthority("user"))).and()
        .withUser("normal").password(passwordEncoder1().encode("normal"))
        .authorities(List.of(new SimpleGrantedAuthority("normal")))
        ;

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin").hasAuthority("ADMIN")
                .antMatchers("/user").hasAnyAuthority("user","ADMIN")
                .anyRequest().authenticated().and().formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder1(){
        return new BCryptPasswordEncoder();
    }
}
