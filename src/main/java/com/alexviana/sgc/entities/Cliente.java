package com.alexviana.sgc.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.alexviana.sgc.enums.StageCliente;
import com.alexviana.sgc.enums.TipoCliente;

@Entity
@Table(name = "cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = -4708598743087418468L;
	
	private Long id;
	private String nome;
	private String cpf;
	private String cnpj;
	private String codigoPostal;
	private String email;
	private TipoCliente tipo;
	private StageCliente stage;
	private String telefone1;
	private String telefone2;
	
	public Cliente( ) { }
	
	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@NotEmpty(message = "Nome é obrigatório!")
	@Length(min = 3, max = 100, message = "O campo deve ter no mínimo 3 e no máximo 100 caracteres.")
	@Column(name = "nome", nullable = true)
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@NotEmpty(message = "CPF é obrigatório!")
	@Column(name = "cpf", nullable = true)
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	@NotEmpty(message = "O CNPJ é obrigatório!")
	@Column(name = "cnpj", nullable = true)
	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	@Column(name = "codigo_postal", nullable = false)
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	@NotEmpty(message = "E-mail é obrigatório!")
	@Length(min = 8, max = 50, message = "O campo deve ter no mínimo 8 e no máximo 50 caracteres.")
	@Column(name = "email", nullable = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	@NotEmpty(message = "Tipo é obrigatório!")
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = true)
	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "stage", nullable = true)
	public StageCliente getStage() {
		return stage;
	}

	public void setStage(StageCliente stage) {
		this.stage = stage;
	}

	@NotEmpty(message = "Telefone é obrigatório!")
	@Column(name = "telefone1", nullable = false)
	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	@Column(name = "telefone2", nullable = false)
	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
}
