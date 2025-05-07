package edu.br.utpfr.trabalho_pw44s.server.repository;

import edu.br.utpfr.trabalho_pw44s.server.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {
    List<Sale> findByBuyerId(Long buyerId);
}
