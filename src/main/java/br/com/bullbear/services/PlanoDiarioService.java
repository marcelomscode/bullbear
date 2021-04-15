package br.com.bullbear.services;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.bullbear.model.PlanoDiario;
import br.com.bullbear.repository.PlanoDiarioRepository;
import br.com.bullbear.util.DataConverter;

@Service
public class PlanoDiarioService {
	
	@Autowired AtivosService ativosService;
	@Autowired PlanoDiarioRepository planoDiarioRepository;
	
	public PlanoDiario salvaPlanoDiario(String ativo, String data,String pontos,String contratos,String  gainLoss) throws ParseException {
		
		PlanoDiario planoDiario = new PlanoDiario();
		planoDiario.setData(DataConverter.converteStringDate(data));
		planoDiario.setAtivo(ativosService.FindOne(Long.parseLong(ativo)));
		planoDiario.setPontos(Float.parseFloat(pontos));
		planoDiario.setContratos(Integer.parseInt(contratos));
		planoDiario.setGainLoss(DataConverter.realParaDolar(gainLoss));
		
		planoDiarioRepository.save(planoDiario);
		
		return planoDiario;
		
	}
	
	public List<PlanoDiario> getByDate(String data){
		return planoDiarioRepository.findByData(data);
	}

	public List<PlanoDiario> getByMounth(String data){
		
		List<PlanoDiario> plan = planoDiarioRepository.findByMounth(data);
		
		return planoDiarioRepository.findByMounth(data);
	}
	
	
}
