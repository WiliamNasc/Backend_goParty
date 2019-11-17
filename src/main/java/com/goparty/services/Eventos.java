package com.goparty.services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Eventos {
	
	
	//TODO colocar valor da entrada
	private int id;
	private String nome;
	private String faixaEtaria;
	private String classificacao;
	private String local;
	private String dataEvento;
	private String horaInicio;
	private String horaFim;
	
	public Eventos() {
	}
	
	public Eventos(int id) {
		super();
		this.id = id;
	}

	public Eventos(String nome, String faixaEtaria, String classificacao, String local, String dataEvento,
			String horaInicio, String horaFim) {
		super();
		this.nome = nome;
		this.faixaEtaria = faixaEtaria;
		this.classificacao = classificacao;
		this.local = local;
		this.dataEvento = dataEvento;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	@Column(name = "nome", nullable = false)
	public String getNome() {
		return nome;
	}

	@Column(name = "faixa_etaria", nullable = false)
	public String getFaixaEtaria() {
		return faixaEtaria;
	}

	@Column(name = "classificacao", nullable = false)
	public String getClassificacao() {
		return classificacao;
	}

	@Column(name = "local", nullable = false)
	public String getLocal() {
		return local;
	}

	@Column(name = "data_evento", nullable = false)
	public String getDataEvento() {
		return dataEvento;
	}

	@Column(name = "hora_inicio", nullable = false)
	public String getHoraInicio() {
		return horaInicio;
	}

	@Column(name = "hora_fim", nullable = false)
	public String getHoraFim() {
		return horaFim;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setFaixaEtaria(String faixaEtaria) {
		this.faixaEtaria = faixaEtaria;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public void setDataEvento(String dataEvento) {
		this.dataEvento = dataEvento;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

}
