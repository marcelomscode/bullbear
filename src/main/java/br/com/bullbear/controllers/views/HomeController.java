package br.com.bullbear.controllers.views;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.bullbear.model.BullBear;
import br.com.bullbear.model.PlanoDiario;
import br.com.bullbear.services.AtivosService;
import br.com.bullbear.services.BullbearServices;
import br.com.bullbear.services.TaxasServices;
import br.com.bullbear.util.DataConverter;

@Controller
public class HomeController {
	
	@Autowired AtivosService ativosService;
	@Autowired TaxasServices taxasServices;
	
	@Autowired BullbearServices bullBearServices;
	
	
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public Model loginPage(Model model) {
	   	
//     	model.addAttribute("result",taxasServices.getall().getBody());
        model.addAttribute("ativos",ativosService.getAll() );
        model.addAttribute("registros", bullBearServices.findByDataOrderByData("2021-04"));
       	
		return model;
	}
	
	
	@GetMapping("/valor")
	@ResponseBody
	public String converter() {
		
		BigDecimal v = DataConverter.realParaDolar("2.006,63");
		
		String valor = v.toPlainString();
		
		return valor;
	}
	
	
	@PostMapping(value="/addBullBear") 
	public ResponseEntity<BullBear> AddMoviments(
			@RequestParam("ativo") String ativo,
			@RequestParam("data") String data,
			@RequestParam("gainLoss") String  gainLoss,
			@RequestParam("emolumentos") String emolumentos,
			@RequestParam("txRegistro") String txRegistro,
			@RequestParam("irrf") String irrf,
			@RequestParam("darf") String darf,
			@RequestParam("total") String total, HttpEntity<String> request ){

		String url = 	"http://localhost:8080/bullbear/addBullBear";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<BullBear> entity	= restTemplate.postForEntity(url, request, BullBear.class);
		
		return entity;
	}
	
	@RequestMapping(value="/acoes", method=RequestMethod.GET)
	public Model acoes(Model model) {
	   	System.out.println("");
//     	model.addAttribute("result",taxasServices.getall().getBody());
//        model.addAttribute("ativos",ativosService.getAll() );
 //       model.addAttribute("registros", bullBearServices.getall());
       	
		return model;
	}
	@RequestMapping(value="/planodiario", method=RequestMethod.GET)
	public Model planoDiario(Model model,HttpEntity<String> request) {
//      model.addAttribute("registros", bullBearServices.getall());
		
		String data = "2021-04";
		
		String url ="http://localhost:8080/planoDiario/getByMounth";

		try {
			RestTemplate restTemplate = new RestTemplate(); 
			
			ResponseEntity<PlanoDiario[]> entity =  restTemplate.getForEntity(url + "?data="+data, PlanoDiario[].class);
			
			model.addAttribute("registros", entity.getBody());
		} catch (Exception e) {
			System.out.println(e.getCause());
		}
		
		model.addAttribute("ativos",ativosService.getAll() );
		
		return model;
	}
	
	@PostMapping(value="/addPlanoDiario") 
	public ResponseEntity<PlanoDiario> addPlanoDiario(HttpEntity<String> request,Model model ){
		String url = 	"http://localhost:8080/planoDiario/addPlanoDiario";
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<PlanoDiario> entity =  restTemplate.postForEntity(url, request, PlanoDiario.class);
		
		return entity;
	}
	
	
	
}
