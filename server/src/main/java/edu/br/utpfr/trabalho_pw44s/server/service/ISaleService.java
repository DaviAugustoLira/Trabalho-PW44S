package edu.br.utpfr.trabalho_pw44s.server.service;

import edu.br.utpfr.trabalho_pw44s.server.dto.SaleRequestDto;
import edu.br.utpfr.trabalho_pw44s.server.model.Sale;

import java.util.List;

public interface ISaleService extends ICrudService<Sale, Long>{
    Sale save(SaleRequestDto requestDto);
    List<Sale> findByBuiyerId(Long id);
}
