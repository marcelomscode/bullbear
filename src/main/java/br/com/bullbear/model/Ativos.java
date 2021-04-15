package br.com.bullbear.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ativos")
public class Ativos {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigoAtivo;
	private String ativo;

	public long getCodigoAtivo() {
		return codigoAtivo;
	}

	public void setCodigoAtivo(long codigoAtivo) {
		this.codigoAtivo = codigoAtivo;
	}

	public String getAtivo() {
		return ativo;
	}

	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}

}
