package com.modulo1.crud.trabalho.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	// super(msg) - RECEBE NO CONSTRUTOR DA SUPERCLASSE UM PARAMETRO COM A msg E PASSA A msg POR PARAMETRO PARA O CONSTRUTOR DA SUBCLASSE Exception QUE FOI ESTENDIDA (extends)
	public ResourceNotFoundException(String msg) {
		super(msg);
	}

}
