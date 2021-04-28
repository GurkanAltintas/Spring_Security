package net.spring.security.repository;

import net.spring.security.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users,Long> {

    Users findByUsername(String username);
    void deleteByUsername(String username);
    boolean existsUsersByUsername(String username);



}
