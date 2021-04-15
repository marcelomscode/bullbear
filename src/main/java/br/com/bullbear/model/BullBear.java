package br.com.bullbear.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bullbear")
public class BullBear {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private Date Data;
	private BigDecimal GainLoss;
	private BigDecimal Darf;
	private BigDecimal total;

	
	@OneToOne
	@JoinColumn(name="codigo_ativo")
	private Ativos ativo;
	
	@ManyToOne
	@JoinColumn(name="codigo_taxas")
	private Taxas taxas;
	
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public Ativos getAtivo() {
		return ativo;
	}
	public void setAtivo(Ativos ativo) {
		this.ativo = ativo;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	public Date getData() {
		return Data;
	}
	public void setData(Date data) {
		Data = data;
	}
	public BigDecimal getGainLoss() {
		return GainLoss;
	}
	public void setGainLoss(BigDecimal gainLoss) {
		GainLoss = gainLoss;
	}
	public BigDecimal getDarf() {
		return Darf;
	}
	public void setDarf(BigDecimal darf) {
		Darf = darf;
	}
	public Taxas getTaxas() {
		return taxas;
	}
	public void setTaxas(Taxas taxas) {
		this.taxas = taxas;
	}
	
	@Override
	public String toString() {
		return "BullBear [Data=" + Data + ", GainLoss=" + GainLoss + ", Darf=" + Darf + ", total=" + total + ", ativo="
				+ ativo.getAtivo() + ", taxas=" + taxas.getEmolumentos() + "]";
	}
	
}
