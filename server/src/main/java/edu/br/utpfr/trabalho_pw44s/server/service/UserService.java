package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.error.exception.Conflict;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    @SneakyThrows
    public User save(User user){
        if(repository.findUserByUsername(user.getUsername()) != null) throw new Conflict("Conflict username");
        if(repository.findUserByEmail(user.getEmail()) != null) throw new Conflict("Conflict email");
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }
}
