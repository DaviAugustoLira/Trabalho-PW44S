package edu.br.utpfr.trabalho_pw44s.server.controller;

import edu.br.utpfr.trabalho_pw44s.server.security.dto.UserResponseDTO;
import edu.br.utpfr.trabalho_pw44s.server.service.AuthService;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;
    private final ModelMapper modelMapper;

    public AuthController(AuthService authService, ModelMapper modelMapper) {
        this.authService = authService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("user-info")
    public UserResponseDTO getUserInfo(Principal principal) {
        // String username = SecurityContextHolder.getContext().getAuthentication().getName();
        // ou
        String username = principal.getName();
        return modelMapper.map(authService.loadUserByUsername(username), UserResponseDTO.class);
    }
}
