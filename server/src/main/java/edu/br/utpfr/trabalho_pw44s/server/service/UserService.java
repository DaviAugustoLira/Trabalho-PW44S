package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


//@RequiredArgsConstructor

@Service
public class UserService{
    private final UserRepository repository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository) {
        this.repository = userRepository;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    public User save(User user){
        if(repository.findUserByUsername(user.getUsername()) != null) throw new RuntimeException();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
