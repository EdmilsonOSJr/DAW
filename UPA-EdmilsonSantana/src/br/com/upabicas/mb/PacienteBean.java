package br.com.upabicas.mb;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.upabicasreal.dao.DAO;
import br.com.upareal.modelo.Atendimento;
import br.com.upareal.modelo.Medico;
import br.com.upareal.modelo.Paciente;

@ViewScoped
@ManagedBean
public class PacienteBean implements Serializable {

	private Paciente paciente = new Paciente();
	private Atendimento atendimento = new Atendimento();
	private Long idMedico;

	
	
	
	public Long getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Long idMedico) {
		this.idMedico = idMedico;
	}

	public Atendimento getAtendimento() {
		return atendimento;
	}

	public void setAtendimento(Atendimento atendimento) {
		this.atendimento = atendimento;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public void gravar() {

		DAO<Paciente> dao = new DAO<Paciente>(Paciente.class);
		dao.adiciona(paciente);
		this.paciente = new Paciente();
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void guardaAtendimento() {
		
		DAO<Medico> dao = new DAO<Medico>(Medico.class);
		
		Medico medico = dao.buscaPorld(idMedico);
		System.out.println(medico.getNome());
		atendimento.setMedico(medico);
		
		paciente.getAtendimentos().add(atendimento);
		atendimento.setPaciente(paciente);

		atendimento = new Atendimento();
	
	}
}
