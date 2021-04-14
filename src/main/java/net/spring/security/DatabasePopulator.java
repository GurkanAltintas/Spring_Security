package net.spring.security;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import net.spring.security.entity.Users;
import net.spring.security.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class DatabasePopulator {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void populateDatabase(){

        Users user=new Users(null,"bygurkan123",passwordEncoder.encode("ankara103"), Set.of());
        userRepository.save(user);
    }
}
