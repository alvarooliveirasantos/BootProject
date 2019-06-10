package br.com.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.entidades.Boot;
import br.com.entidades.Message;

public class BootDAO {
	
	private static List<Boot> bootsList = new ArrayList<Boot>();
	
	

	public List<Boot> listarTodos() {
		return bootsList;
	}

	public String adcionar(Boot boot) {
		for (Boot boots : bootsList) {
			if(boot.getId() == boots.getId()){
				return "Boot ja cadastrado";
			}	
		}
		bootsList.add(boot);	
		return "OK";
	}
	public void alterar(Boot boot) {
		Boot alterar = null;
		for (Boot boots : bootsList){
			if(boot.getId() == boots.getId()){
			alterar = boots;				
			}
		}
		bootsList.remove(alterar);
		bootsList.add(boot);
		
	}
	public void excluir(Long id) {
		Boot excluir = null;
		for (Boot boots : bootsList){
			if(id == boots.getId()){
				excluir = boots;				
			}
		}
		bootsList.remove(excluir);
		
	}
	public List<Boot> listarPorId(Long id) {
			List<Boot> boot = new ArrayList<Boot>();
			for (Boot boots : bootsList) {
				if(boots.getId().equals(id)){
					boot.add(boots);
				}
			}
			return boot;
		}
	}
	


