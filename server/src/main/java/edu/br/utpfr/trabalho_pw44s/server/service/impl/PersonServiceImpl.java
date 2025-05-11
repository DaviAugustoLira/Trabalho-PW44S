package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.PersonResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.error.exception.Conflict;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.PersonRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IAddressService;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class PersonServiceImpl extends CrudServiceImpl<Person, Long> implements IPersonService {
    private final PersonRepository repository;
    private final UserRepository userRepository;
    private final ModelMapper mapper;


    @SneakyThrows
    @Override
    public PersonResponseDto create(PersonRequestDto request, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        if(user == null) throw new EntityNotFoundException("User Not Found!");

        if(repository.existsByCpfOrCnpj(request.getCpf(), request.getCnpj())) throw new Conflict("Conflict Person document");

        Person person = mapper.map(request, Person.class);
        person.setUser(user);

        Person save = save(person);
        return mapper.map(save, PersonResponseDto.class);
    }

    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Person> iterable) {

    }
}
