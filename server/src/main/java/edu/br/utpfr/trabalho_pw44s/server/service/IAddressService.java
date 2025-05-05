package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Address;

public interface IAddressService extends ICrudService<Address, Long>{
    Address save(AddressRequestDto requestDto);
}
