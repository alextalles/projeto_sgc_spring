package com.alexviana.sgc.enums;

public enum StageCliente {
	
	ATIVO ("Ativo"),
	INATIVO ("Inativo");
	
	private final String descricao;
	
	StageCliente(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
