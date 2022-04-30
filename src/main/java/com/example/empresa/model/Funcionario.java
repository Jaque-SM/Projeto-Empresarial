package com.example.empresa.model;

import javax.persistence.Entity;
import javax.validation.Valid;

@Entity
public class Funcionario {
	
	private Long id;
	private String nome_completo;
	private String cargo;
	private String cpf;
	private String email;
	private String telefone;
	
	
	public Funcionario(long id, String nome_completo, String cargo, String cpf, String email2, String telefone2) {
		super();
		this.id = id;
		this.nome_completo = nome_completo;
		this.cargo = cargo;
		this.cpf = cpf;
		this.email = email2;
		this.telefone = telefone2;
	}


	public Funcionario() {
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome_completo() {
		return nome_completo;
	}
	public void setNome_completo(String nome_completo) {
		this.nome_completo = nome_completo;
	}
	
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	

	
	
	
	

}
