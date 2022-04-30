 package com.example.empresa.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.empresa.model.Funcionario;
import com.example.empresa.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {
	
	//foi criado uma lista e 3 objetos do tipo Funcionario
	List<Funcionario> lista;
	Funcionario ava;
	Funcionario abe;
	Funcionario duo; 
	
	/*é criado um construtor onde vai armazenar os valores dos objetos
	e é add na lista cada objeto*/
	public FuncionarioServiceImpl() {
		 this.ava=new Funcionario(1, "Jaqueline", "Dev", "13359745",
				"jaqueline.moreno@gmail.com", "64879251" );
		 this.abe=new Funcionario(2, "Rafael", "Assistente", "3652124",
				"rafael.souza@gmail.com", "3685455" );
		 this.duo=new Funcionario(3, "Karla", "Agente", "3269857",
				 "karla.costa@gmail.com", "96325874");
		lista=new ArrayList<Funcionario>();
			 lista.add(ava);
			 lista.add(abe);
			 lista.add(duo);
	}	
	
	@Override
	/*esse metodo é o responsavel por pegar o objeto de cada 
	 * lista acima e add dentro dessa mesma lista */ 
	public Funcionario addFuncionario(Funcionario fan) {
		String email="maria.moreno@gmail.com";
		if (email.equals(fan.getEmail())) {
			System.out.print("Ja existe uma pessoa com esse email");
		}
		if (fan!=null) {
		lista.add(fan);
		}
		return fan;
	}

	@Override
	//metodo que vai dar uma atualização no objeto da lista de 
	//de acordo com o id fornecido no parametro abaixo
	public Funcionario updateFuncionario(Long id, Funcionario fan) {
		 for (Funcionario ave: lista) {
		    	if (ave.getId()==id) {
		    		ave.setNome_completo(fan.getNome_completo());
		    		ave.setCargo(fan.getCargo());
		    		ave.setCpf(fan.getCpf());
		    		ave.setEmail(fan.getEmail());
		    		ave.setTelefone(fan.getTelefone());
		    		return fan;
		    	}
		 }
		 return null;
	}
	//metodo que vai listar tudo no postman
	@Override
	public List<Funcionario> listarFuncionarios() {
		 return lista;
		 
	}
	//metodo que retorna um funcionario (obj) por Id fornecido
	@Override
	public Funcionario buscarPorID(Long id) {
		int num=id.intValue();
		    for (Funcionario ave: lista) {
		    	if (ave.getId()==id) {
		    	return ave;
		    	}
		    }
		return null;
	}

	@Override
	public String removeFuncionario(Long id) {
		 for (Funcionario ave: lista) {
		    	if (ave.getId()==id) {
		    		lista.remove(ave);
			    	return "Funcionario excluido";
		    	}
		  }   
		  return "Ninguem encontrado com esse Id";
	}




}
