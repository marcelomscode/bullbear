package br.com.bullbear.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.bullbear.model.BullBear;

public interface BullBearRepository extends JpaRepository<BullBear, Long>{

	@Query("SELECT c FROM BullBear c where data like :data% order by data desc")
	List<BullBear> findByDataOrderByData(@Param("data") String data);
	
	
}
