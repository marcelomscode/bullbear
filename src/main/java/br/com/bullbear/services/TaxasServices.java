package br.com.bullbear.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.bullbear.model.Taxas;
import br.com.bullbear.repository.TaxasRepository;

@Service
public class TaxasServices {
	
	
	@Autowired TaxasRepository taxasRepository;
	
	public ResponseEntity<Taxas[]> getall(){
		
		RestTemplate restTemplate = new RestTemplate();
       	ResponseEntity<Taxas[]> p = restTemplate.getForEntity("http://localhost:8080/bullbear", Taxas[].class);
		
       	return p;
       	
	}
	
	public void save(Taxas taxas) {
		taxasRepository.save(taxas);
	}
	
	
	
}
