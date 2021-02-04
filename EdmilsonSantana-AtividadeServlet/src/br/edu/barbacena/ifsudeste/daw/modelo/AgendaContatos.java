package br.edu.barbacena.ifsudeste.daw.modelo;

import java.util.ArrayList;
import java.util.List;

public class AgendaContatos {
	
	private static List<Contato> contatos;
	
	
	
	public AgendaContatos() {
		contatos = new ArrayList<Contato>();
	}

	
	public int pesquisarContato(String nome) {
		for(Contato contato: contatos) {
			if(contato.getNome().equalsIgnoreCase(nome))
				return contatos.indexOf(contato);
		}
		return -1;
	}
	
	
	public boolean adicionaContato(Contato contato) {
		
		int indice = pesquisarContato(contato.getNome());
		
		if(indice==-1) {
			contatos.add(contato); 
			return true;
		}
		else 
			return false;
	}
	
	public boolean removeContato(String nome) {
		
		int indice = pesquisarContato(nome);
		
		if(indice==-1)
			return false;
		else {
			contatos.remove(indice);
			return true;
		}
	}
	
		
	public List<Contato> listaContatos() {
		return contatos;
	}
	
}
