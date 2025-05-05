package edu.br.utpfr.trabalho_pw44s.server.repository;

import edu.br.utpfr.trabalho_pw44s.server.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
