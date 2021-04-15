package br.com.bullbear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bullbear.model.Taxas;

@Repository
public interface TaxasRepository extends JpaRepository<Taxas, Long>{

}
