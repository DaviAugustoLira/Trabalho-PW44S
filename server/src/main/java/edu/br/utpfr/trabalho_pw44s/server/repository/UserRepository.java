package edu.br.utpfr.trabalho_pw44s.server.repository;

import edu.br.utpfr.trabalho_pw44s.server.model.User;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByUsername(String username);
    User findUserByEmail(@Email String email);
}
