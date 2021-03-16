package br.com.upabicas.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.upabicasreal.dao.DAO;
import br.com.upareal.modelo.Medico;

@ViewScoped
@ManagedBean
public class MedicoBean {
	
	private Medico medico = new Medico();
	private List<Medico> medicos;
	
	public Medico getMedico() {
		return this.medico;
	}
	
	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public void grava() {
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		
		if(medico.getCrm() == null) {
			dao.adiciona(medico);
		} else {
			dao.atualiza(medico);
		}
		
		this.medico = new Medico();
		this.medicos = dao.listaTodos();
	}
	
	public List<Medico> getMedicos(){
		
		if(medicos == null) {
			System.err.println("Carregando médicos... ");
			medicos = new DAO<Medico>(Medico.class).listaTodos();
		}
		return medicos;
		
	}
	
	public Double getSalarioTotal() {
		
		Double salTotal = 0.0;
		
		for(Medico medico: this.medicos) {
			salTotal+=medico.getSalario();
		}
		
		
		return salTotal;
	}
	
	public void remove(Medico medico) {
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		
		dao.remove(medico);
		
		this.medicos = dao.listaTodos();
	}
	
	public void cancela() {
		this.medico = new Medico();
	}
}
