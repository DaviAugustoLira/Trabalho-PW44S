package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;
import edu.br.utpfr.trabalho_pw44s.server.model.Person;

import java.util.List;

public interface IAddressService extends ICrudService<Address, Long>{
    Address save(AddressRequestDto requestDto);
}
