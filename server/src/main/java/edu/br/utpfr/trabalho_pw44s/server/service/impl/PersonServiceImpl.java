package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.PersonRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.PersonRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IAddressService;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import edu.br.utpfr.trabalho_pw44s.server.service.IPersonService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor

@Service
public class PersonServiceImpl extends CrudServiceImpl<Person, Long> implements IPersonService {
    private final PersonRepository repository;
    private final UserRepository repositoryUser;
    private final ModelMapper mapper;

    @Override
    public Person save(PersonRequestDto requestDto) {
        Person person = mapper.map(requestDto, Person.class);
        person.setUser(repositoryUser.findById(requestDto.getUser()).orElseThrow(() -> new EntityNotFoundException("Not Found!")));
        return repository.save(person);
    }

    @Override
    protected JpaRepository<Person, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Person> iterable) {

    }
}
