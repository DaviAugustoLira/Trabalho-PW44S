package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import jakarta.validation.Valid;

import java.security.Principal;


public interface IPersonService extends ICrudService<Person, Long>{
    PersonResponseDto create(PersonRequestDto request, Principal principal);
}
