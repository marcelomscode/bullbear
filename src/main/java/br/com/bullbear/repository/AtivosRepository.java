package br.com.bullbear.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bullbear.model.Ativos;

@Repository
public interface AtivosRepository extends JpaRepository<Ativos, Long>{

}
