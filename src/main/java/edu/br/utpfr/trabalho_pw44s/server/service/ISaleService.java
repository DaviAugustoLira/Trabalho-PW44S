package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.AddressRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.AddressResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.dto.SaleResponseDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import jakarta.validation.Valid;

import java.security.Principal;
import java.util.List;

public interface ISaleService extends ICrudService<Sale, Long>{
    List<Sale> findByBuyer(Principal principal);
    SaleResponseDto create(SaleRequestDto request, Principal principal);
}
