package com.wbjee.oceanapp.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.wbjee.oceanapp.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
