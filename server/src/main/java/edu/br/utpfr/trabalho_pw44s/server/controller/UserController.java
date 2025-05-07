package edu.br.utpfr.trabalho_pw44s.server.controller;


import edu.br.utpfr.trabalho_pw44s.server.dto.UserRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.UserResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IUserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("user")
public class UserController extends CrudController<User, UserRequestDto, UserResponseDto, Long>{

    private static IUserService service;
    private static ModelMapper mapper;

    public UserController(IUserService service, ModelMapper mapper){
        super(User.class, UserResponseDto.class, UserRequestDto.class);
        UserController.service = service;
        UserController.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> save(@RequestBody @Valid UserRequestDto requestDto){
        User user = mapper.map(requestDto, User.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.map(service.saveEncrypt(user), UserResponseDto.class));
    }

    @Override
    protected ICrudService<User, Long> getService() {
        return service;
    }

    @Override
    protected ModelMapper getModelMapper() {
        return mapper;
    }
}
