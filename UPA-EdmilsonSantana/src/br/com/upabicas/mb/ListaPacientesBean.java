package br.com.upabicas.mb;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.upabicasreal.dao.DAO;
import br.com.upareal.modelo.Paciente;

@ManagedBean
public class ListaPacientesBean implements Serializable{
	private Paciente paciente = new Paciente();
	private List<Paciente> pacientes;
	
	
	public List<Paciente> getPacientes(){
		if(pacientes==null) {
			System.out.println("Carregando pacientes...");
			pacientes = new DAO<Paciente>(Paciente.class).listaTodos();
		}
		
		return pacientes;
	}
	
}
