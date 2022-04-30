package com.example.empresa.service;

import java.util.List;

import com.example.empresa.model.Funcionario;


public interface FuncionarioService {

	
	public abstract Funcionario addFuncionario(Funcionario fan);
	
	public abstract Funcionario updateFuncionario(Long id, Funcionario fan);
	
	public abstract String removeFuncionario(Long id);
	
	public abstract List<Funcionario> listarFuncionarios();
		
	public abstract Funcionario buscarPorID(Long id);
		
	
	
}
