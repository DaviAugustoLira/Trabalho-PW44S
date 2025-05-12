package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;
import jakarta.validation.Valid;

import java.security.Principal;
import java.util.List;

public interface IAddressService extends ICrudService<Address, Long>{
    Address save(Address address);
    AddressResponseDto create(AddressRequestDto request, Principal principal);
    List<Address> findAllByUsername(Principal principal);
}
