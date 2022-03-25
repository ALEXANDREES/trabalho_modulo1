package com.modulo1.crud.trabalho.controller.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.modulo1.crud.trabalho.services.exceptions.ResourceNotFoundException;

/*
 * @ControllerAdvice - ANOTAÇÃO QUE TEM A FUNÇÃO DE INTERCEPTAR UMA POSSIVEL EXCEÇÃO NA CAMADA DOS CONTROLLERS
 * 
 * @ExceptionHandler - INDICA O TIPO DE EXCEÇÃO PERSONALIZADA QUE VAI SER TRATADA CONFORME O PARAMETRO PASSADO
 */

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardErrorController> entityNotFound(ResourceNotFoundException e, HttpServletRequest req) {
		HttpStatus status = HttpStatus.NOT_FOUND; // CAPTURA O ERRO HTTP
		StandardErrorController errorController = new StandardErrorController();
		errorController.setTimestamp(Instant.now()); // CRIA UMA DATA ATUAL PARA ESSE RETORNO
		errorController.setStatus(status.value()); // CAPTURA O CODIGO DO ERRO HTTP
		errorController.setError("Resource not found"); 
		errorController.setMessage(e.getMessage()); // CAPTURA A MENSAGEM DA EXCEÇÃO DEFINIDA NO SERVICE
		errorController.setPath(req.getRequestURI()); // CAPTURA O CAMINHO DA REQUISIÇÃO
		
		return ResponseEntity.status(status).body(errorController);
	}
}
