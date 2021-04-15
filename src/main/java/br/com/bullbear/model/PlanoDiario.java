package br.com.bullbear.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="planodiario")
public class PlanoDiario {
	
	public PlanoDiario() {

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Date Data;
	private float pontos;
	private BigDecimal gainLoss;
	private int contratos;
	
	@OneToOne
	@JoinColumn(name="codigo_ativo")
	private Ativos ativo;
	
	public Ativos getAtivo() {
		return ativo;
	}
	public void setAtivo(Ativos ativo) {
		this.ativo = ativo;
	}
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	
	public BigDecimal getGainLoss() {
		return gainLoss;
	}
	public void setGainLoss(BigDecimal gainLoss) {
		this.gainLoss = gainLoss;
	}
	public float getPontos() {
		return pontos;
	}
	public void setPontos(float pontos) {
		this.pontos = pontos;
	}
	public int getContratos() {
		return contratos;
	}
	public void setContratos(int contratos) {
		this.contratos = contratos;
	}
	
	
	
	
}
