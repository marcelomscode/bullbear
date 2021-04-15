package br.com.bullbear.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.bullbear.model.PlanoDiario;

@Repository
public interface PlanoDiarioRepository extends JpaRepository<PlanoDiario, Long>{
	
	@Query("SELECT c FROM PlanoDiario c where data = :data order by data")
	List<PlanoDiario> findByData(@Param("data") String data);

	@Query("SELECT c FROM PlanoDiario c where data like :data% order by data desc")
	List<PlanoDiario> findByMounth(@Param("data") String data);
	
	
}
