package br.edu.barbacena.ifsudestemg.daw.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class TestarAlunoDAO {
	
	private  AlunoDAO dao;
	private  Scanner entrada;
	
	
	// chama construtor
	public static void main(String[] args) {
		new TestarAlunoDAO();
	}
	
	
	// da valor as variaveis e chama a função que inicia a interação
	public TestarAlunoDAO() {
		dao = new AlunoDAO();
		entrada = new Scanner(System.in);
		inicializa();
	}
	
	
	public void inicializa() {
		
		int opcao = 0;

		while(true) {
			System.out.println(
					"\n=> Escolha uma dentre as opções" + "\n1-Adicionar Aluno\n2-Remover "
							+ "Aluno\n3-Atualizar Aluno\n4-Listar Alunos\n0-Sair");
			try {
				opcao = Integer.parseInt(entrada.nextLine());
				if(opcao != 0) {
					menu(opcao);
				}
				else {
					entrada.close();
					break;					
				}
			} catch (NumberFormatException e) {
				entrada.nextLine();
				System.err.println("Digite um dos número!!!");
			}
			
		}
		
	}
	
	public void menu(int opcao) {

		Aluno aluno = new Aluno();
		
		switch (opcao) {
		case 1:
			dao.adiciona(lerDados(aluno));
			break;
		case 2:
			dao.remove(PegarId());
			break;
		case 3:
			dao.altera(lerDados(PegarId()));
			break;
		case 4:
			exibeAlunos(dao.listaAlunos());
			break;
		default:
			System.out.println("Número incorreto!!!");
			break;
		}
		
	}
	
	
	
	public Aluno PegarId() {

		Aluno aluno = new Aluno();
		Long id;
		
		while(true) {			
			try {
				System.out.println("\nForceça o id do aluno:");
				id = Long.parseLong(entrada.nextLine());
				break;
			} catch (NumberFormatException e) {
				entrada.nextLine();
				System.err.println("Dados inconpatíves !!!");
			}
		}
		
		aluno.setId(id);	
		return aluno;
	}
	
	public void exibeAlunos(List<Aluno> alunos) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Aluno aluno : alunos) {
			System.out.println(String.format("\nId = %d\nNome = %s\nEmail = %s\nEndereço = %s\n"
											+ "data de nacimento = %s ", aluno.getId(),aluno.getNome(),
											aluno.getEmail(),aluno.getEndereco(),df.format(aluno.getDataNascimento().getTime())));
		}
	}
	
	public Aluno lerDados(Aluno aluno) {

		String nome, email, endereco, dataNacimento;	
		Calendar data = Calendar.getInstance();
		SimpleDateFormat df ;
		
		while(true) {			
			try {
				System.out.println("\nForceça o os dados do aluno: nome, email, endereço e data de nascimento "
						+ "respectivamente, sendo data no formato dd/MM/YYYY:");
				nome = entrada.nextLine();
				email = entrada.nextLine();
				endereco = entrada.nextLine();
				dataNacimento = entrada.nextLine();	
	
				df = new SimpleDateFormat("dd/MM/yyyy");
				data.setTime(df.parse(dataNacimento));
				break;
			} catch (ParseException e) {
				entrada.nextLine();
				System.err.println("Dados inconpatíves !!!");
			}
		}
		
		aluno.setNome(nome);
		aluno.setEmail(email);
		aluno.setEndereco(endereco);
		aluno.setDataNascimento(data);
		return aluno;
		
	}
	
	
	
}
