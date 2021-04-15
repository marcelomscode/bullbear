package br.com.bullbear.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import br.com.bullbear.model.Ativos;
import br.com.bullbear.repository.AtivosRepository;

@Service
public class AtivosService {
	
	@Autowired AtivosRepository ativosRepository;
	
	public List<Ativos> getAll(){
		return ativosRepository.findAll();	
	}	
	
	public Ativos FindOne(Long codigo) {
		Ativos ativo = ativosRepository.findById(codigo)
				.orElseThrow(() -> new EmptyResultDataAccessException(1));
		return ativo;
	}
	
}
