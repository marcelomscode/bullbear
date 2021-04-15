package br.com.bullbear.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bullbear.model.BullBear;
import br.com.bullbear.model.Taxas;
import br.com.bullbear.repository.BullBearRepository;
import br.com.bullbear.repository.TaxasRepository;
import br.com.bullbear.util.DataConverter;

@Service
public class BullbearServices {
	
	@Autowired AtivosService ativosService;
	@Autowired BullBearRepository bullBearRepository;
	@Autowired TaxasRepository taxasRepository;
	
	public BullBear salva(String ativo, String data,String  gainLoss,String emolumentos,String txRegistro,String irrf,String darf,String total) throws ParseException {

		Taxas taxas= new Taxas();
		taxas.setEmolumentos(DataConverter.realParaDolar(emolumentos));
		taxas.setIrrf(DataConverter.realParaDolar(irrf));
		taxas.setRegistro(DataConverter.realParaDolar(txRegistro));
		taxasRepository.save(taxas);
		
		BullBear bullBear = new BullBear();
		bullBear.setData(DataConverter.converteStringDate(data));
		bullBear.setGainLoss(DataConverter.realParaDolar(gainLoss));
		bullBear.setTaxas(taxas);
		bullBear.setDarf(DataConverter.realParaDolar(darf));
		bullBear.setTotal(DataConverter.realParaDolar(total));
		bullBear.setAtivo(ativosService.FindOne(Long.parseLong(ativo)));
		
		BullBear response =  bullBearRepository.save(bullBear);
		
		return response;
	}
	
	public List<BullBear> getall(){
		return bullBearRepository.findAll();
	}
	
	public List<BullBear> findByDataOrderByData(String data){
		return bullBearRepository.findByDataOrderByData(data);
	}

	
	
}
