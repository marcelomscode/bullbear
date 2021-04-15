package br.com.bullbear.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="taxas")
public class Taxas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigoTaxas;
	private BigDecimal emolumentos;
	private BigDecimal registro;
	private BigDecimal irrf;

	public BigDecimal getEmolumentos() {
		return emolumentos;
	}
	public void setEmolumentos(BigDecimal emolumentos) {
		this.emolumentos = emolumentos;
	}
	public BigDecimal getRegistro() {
		return registro;
	}
	public void setRegistro(BigDecimal registro) {
		this.registro = registro;
	}
	public BigDecimal getIrrf() {
		return irrf;
	}
	public void setIrrf(BigDecimal irrf) {
		this.irrf = irrf;
	}
	
}
