package edu.br.utpfr.trabalho_pw44s.server.repository;

import edu.br.utpfr.trabalho_pw44s.server.model.Product;
import edu.br.utpfr.trabalho_pw44s.server.model.Product_Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSaleRepository extends JpaRepository<Product_Sale, Long> {
}
