package com.alexviana.sgc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import org.hibernate.type.EnumType;
import org.springframework.data.annotation.Id;

import com.alexviana.sgc.enums.StageEnum;
import com.alexviana.sgc.enums.TipoEnum;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -4708598743087418468L;
	
	private Long id;
	private String nome;
	private String empresa;
	private String codigoPostal;
	private String email;
	private TipoEnum tipo;
	private StageEnum stage;
	
	public Cliente( ) {}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "nome", nullable = true)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name = "empresa", nullable = false)
	public String getEmpresa() {
		return empresa;
	}
	
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	
	@Column(name = "codigo_postal", nullable = false)
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	//@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = true)
	public TipoEnum getTipo() {
		return tipo;
	}

	public void setTipo(TipoEnum tipo) {
		this.tipo = tipo;
	}

	//@Enumerated(EnumType.ENUM)
	@Column(name = "stage", nullable = true)
	public StageEnum getStage() {
		return stage;
	}

	public void setStage(StageEnum stage) {
		this.stage = stage;
	}

}
