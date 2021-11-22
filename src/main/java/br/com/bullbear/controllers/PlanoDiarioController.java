package br.com.bullbear.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.bullbear.model.PlanoDiario;
import br.com.bullbear.services.PlanoDiarioService;

@RestController
@RequestMapping("/planoDiario")
public class PlanoDiarioController {
	
	@Autowired PlanoDiarioService planoDiarioService;
	
	
	@PostMapping(value="/addPlanoDiario")
	public PlanoDiario addPlanoDiario(@RequestParam("ativo") String ativo,
			@RequestParam("data") String data,
			@RequestParam("pontos") String pontos,
			@RequestParam("contratos") String contratos,
			@RequestParam("gainLoss") String  gainLoss) {
	
		
		try {
			
			PlanoDiario response = planoDiarioService.salvaPlanoDiario(ativo, data, pontos, contratos, gainLoss);
			return response;
	
		} catch (Exception e) {
			System.out.println("Ocorreu um problema: " + e);
			return null;
		}
		
   }
	
	
	@GetMapping("/getByDate")
	public List<PlanoDiario> getByDate(String data){
		return planoDiarioService.getByDate(data);
	}

	@GetMapping("/getByMounth")
	public List<PlanoDiario> getByMounth(String data){
		return planoDiarioService.getByMounth(data);
	}
	
	
	
}
