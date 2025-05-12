package edu.br.utpfr.trabalho_pw44s.server.service.impl;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.User;
import edu.br.utpfr.trabalho_pw44s.server.repository.AddressRepository;
import edu.br.utpfr.trabalho_pw44s.server.repository.UserRepository;
import edu.br.utpfr.trabalho_pw44s.server.service.IAddressService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor

@Service
public class AddressServiceImpl extends CrudServiceImpl<Address, Long> implements IAddressService{

    private final AddressRepository repository;
    private final ModelMapper mapper;
    private final UserRepository userRepository;

    @Override
    public Address save(Address address) {
        return this.repository.save(address);
    }

    @Override
    public AddressResponseDto create(AddressRequestDto request, Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        if(user == null) throw new EntityNotFoundException("User Not Found!");
        Address address = mapper.map(request, Address.class);
        address.setUser(user);

        Address save = save(address);
        return mapper.map(save, AddressResponseDto.class);
    }

    @Override
    public List<Address> findAllByUsername(Principal principal) {
        User user = userRepository.findUserByUsername(principal.getName());
        return repository.findByUserId(user.getId());
    }

    @Override
    protected JpaRepository<Address, Long> getRepository() {
        return this.repository;
    }

    @Override
    public void delete(Iterable<? extends Address> iterable) {

    }


}
