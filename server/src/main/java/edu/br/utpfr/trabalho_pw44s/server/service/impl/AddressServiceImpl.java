package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IAddressService;
import edu.br.utpfr.trabalho_pw44s.server.service.ICrudService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long> implements IAddressService{

    private final AddressRepository repository;
    private final ModelMapper mapper;
    private final PersonServiceImpl personService;

    @Override
    public Address save(AddressRequestDto requestDto) {
        Address address = mapper.map(requestDto, Address.class);
        address.setPerson(personService.findById(requestDto.getPerson()));

        return this.repository.save(address);
    }


    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Address> iterable) {
    }
}
