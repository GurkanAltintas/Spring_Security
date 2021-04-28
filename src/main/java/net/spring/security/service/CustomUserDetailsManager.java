package net.spring.security.service;

import lombok.RequiredArgsConstructor;
import net.spring.security.entity.Users;
import net.spring.security.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void createUser(UserDetails userDetails) {

        Users users=(Users) userDetails;
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        userRepository.save(users);
    }

    @Override
    public void updateUser(UserDetails userDetails) {

        Users user = (Users) loadUserByUsername(userDetails.getUsername());
        Users newUser=(Users) user;
        newUser.setId(user.getId());
        userRepository.save(newUser);
    }

    @Override
    public void deleteUser(String s) {

        userRepository.deleteByUsername(s);
    }

    @Override
    public void changePassword(String s, String s1) {

    }

    @Override
    public boolean userExists(String s) {
        return userRepository.existsUsersByUsername(s);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
