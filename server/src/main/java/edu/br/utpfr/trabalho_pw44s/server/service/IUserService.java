package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    User save(User user);
    Page<User> findAll(Pageable pageable);
    List<User> findAll();
    User findById(Long id);
    void delete(User user);
    boolean exists(Long id);
    long count();
}
