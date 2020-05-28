package de.stach.jwtauth.repository;

import java.util.List;
import java.util.Optional;

import de.stach.jwtauth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);

    List<User> findByUsernameContaining(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
