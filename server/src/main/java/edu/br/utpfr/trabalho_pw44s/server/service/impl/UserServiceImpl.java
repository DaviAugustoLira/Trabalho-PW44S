package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository repository;

    @Override
    public User save(User user) {
        return this.repository.save(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<User> findAll(Pageable pageable) {
        return this.repository.findAll(pageable);
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return this.repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public User findById(Long id) {
        return this.repository.findById(id).orElseGet(null);
    }

    @Override
    public void delete(User user) {
        this.repository.delete(user);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists(Long id) {
        return this.repository.existsById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public long count() {
        return this.repository.count();
    }
}
