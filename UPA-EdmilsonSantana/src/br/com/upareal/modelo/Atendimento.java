package br.com.upareal.modelo;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Atendimento {

	@Id
	@SequenceGenerator(
			name="atendimento_id",
			sequenceName="atendimento_seq",
			allocationSize=1)

@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "atendimento_seq")
	private Long id;
	
	@Temporal(TemporalType.DATE)
	private Calendar data = Calendar.getInstance();
	
	private String receita;
	private String recomendacoes;
	
	
	@ManyToOne
	private Medico medico;
	
	@ManyToOne
	private Paciente paciente;
	
	
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	public String getReceita() {
		return receita;
	}
	public void setReceita(String receita) {
		this.receita = receita;
	}
	public String getRecomendacoes() {
		return recomendacoes;
	}
	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
	
	
	
}
