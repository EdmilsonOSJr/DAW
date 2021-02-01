package modelo.java;

import java.util.ArrayList;
import java.util.List;

public class AgendaContatos {
	
	private List<Contato> contatos = new ArrayList<>();
	
	
	public int adicionaContato(Contato contato) {
		
		int indice = pesquisarContato(contato.getNome());
		
		if(indice==-1)
			return indice;
		else {
			contatos.add(contato);
			return 1;
		}
	}
	
	public int pesquisarContato(String nome) {
		for(Contato contato: contatos) {
			if(contato.getNome().equalsIgnoreCase(nome))
				return contatos.indexOf(contato);
		}
		return -1;
	}
	
	public int removeContato(String nome) {
		
		int indice = pesquisarContato(nome);
		
		if(indice==-1)
			return indice;
		else {
			contatos.remove(indice);
			return 1;
		}
	}
	
	
	public int alteraContato(String nome) {
		int indice = pesquisarContato(nome);
		
		if(indice==-1)
			return indice;
		else {
			contatos.remove(indice);
			return 1;
		}
	}
	
	public List<Contato> listaContatos() {
		return contatos;
	}
	
	
	
}
