package edu.br.utpfr.trabalho_pw44s.server.controller;


import edu.br.utpfr.trabalho_pw44s.server.dto.UserRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.security.dto.AuthenticationResponse;
import edu.br.utpfr.trabalho_pw44s.server.security.dto.UserResponseDTO;
import edu.br.utpfr.trabalho_pw44s.server.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor

@RestController
@RequestMapping("user")
public class UserController{

    private final UserService service;
    private final ModelMapper mapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody @Valid UserRequestDto requestDto) {
        User user = this.service.save(mapper.map(requestDto, User.class));
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(user, UserResponseDTO.class));
    }

}
