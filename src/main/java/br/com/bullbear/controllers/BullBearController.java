package br.com.bullbear.controllers;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bullbear.model.BullBear;
import br.com.bullbear.services.BullbearServices;

@RestController
@RequestMapping("/bullbear")
public class BullBearController {
	
	
	@Autowired BullbearServices bullBearServices;
	
	@PostMapping(value="/addBullBear") 
	public BullBear AddMoviments(
			@RequestParam("ativo") String ativo,
			@RequestParam("data") String data,
			@RequestParam("gainLoss") String  gainLoss,
			@RequestParam("emolumentos") String emolumentos,
			@RequestParam("txRegistro") String txRegistro,
			@RequestParam("irrf") String irrf,
			@RequestParam("darf") String darf,
			@RequestParam("total") String total
		){
	
		try {
			
			BullBear response = bullBearServices.salva(ativo, data, gainLoss, emolumentos, txRegistro, irrf, darf, total);
			return response;
		
		} catch (ParseException e) {
			e.getCause();
			return null;
		}
		
	}
	
	
	
}
