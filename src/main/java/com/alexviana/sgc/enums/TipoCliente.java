package com.alexviana.sgc.enums;

public enum TipoCliente {

	FISICA ("fisica"), 
	JURIDICA ("jurídica");
	
	private final String descricao;
	
	TipoCliente(String descricao) { 
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
