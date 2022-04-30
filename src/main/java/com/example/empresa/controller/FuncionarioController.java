package com.example.empresa.controller;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.empresa.model.Funcionario;
import com.example.empresa.serviceImpl.FuncionarioServiceImpl;


@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioServiceImpl aqui;
	
	/*metodo que faz um request-response e chama 
	 * o metodo listar da classe FuncionarioServiceImpl
	 * retornando uma lista no postman com a Request do Get*/
	@GetMapping
	public List<Funcionario>  listar(){
		return aqui.listarFuncionarios();
	}
	/*metodo que faz um request-response e chama 
	 * o metodo addFuncionario da classe FuncionarioServiceImpl
	 * salvando um obj dentro da lista com a request Post*/
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Funcionario adicionar(@Validated @RequestBody Funcionario aln) {
		return aqui.addFuncionario(aln);
	}
	/*metodo que remove  um obj usando o metodo
	 * delete da classe FuncionarioServiceImpl usando o request
	 * DeleteMapping do postman*/
	@DeleteMapping("/{funcionarioId}")
	public ResponseEntity<String> remover(@PathVariable Long funcionarioId) {
		if (funcionarioId!=0) {
		aqui.removeFuncionario(funcionarioId);
		return ResponseEntity.ok("Funcionario excluido");

		}
	return ResponseEntity.notFound().build();

	}
	/*metodo que atualiza  um obj usando o metodo
	 * atualizar da classe FuncionarioServiceImpl usando o request
	 * requisição Put + id do funcionario  do postman*/
	@PutMapping("/{funcionarioId}")
	public ResponseEntity<Funcionario> atualizar(@Valid @PathVariable Long funcionarioId, @RequestBody Funcionario fan ) { 
		if (funcionarioId==0) {
			return ResponseEntity.notFound().build();
		}                                   
		fan=aqui.updateFuncionario(funcionarioId, fan);
		return ResponseEntity.ok(fan);
	}
	/*metodo que busca  um obj do tipo Funcionario usando o metodo
	 * buscar da classe FuncionarioServiceImpl usando o request
	 *  Get + id do funcionario  do postman e obtendo uma requisição como resposta*/
	@RequestMapping(value = "/{funcionarioId}", method = RequestMethod.GET)
	public ResponseEntity<Funcionario> buscar(@PathVariable Long funcionarioId) { 
		
		if (funcionarioId!=0) {
			return ResponseEntity.ok(aqui.buscarPorID(funcionarioId));
		}
		return ResponseEntity.notFound().build();

	}
}
