package br.edu.barbacena.ifsudestemg.daw.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.edu.barbacena.ifsudestemg.daw.dao.AlunoDAO;
import br.edu.barbacena.ifsudestemg.daw.jdbc.ConnectionFactory;
import br.edu.barbacena.ifsudestemg.daw.modelo.Aluno;

public class TestarAlunoDAO {
	
	private static AlunoDAO dao;
	
	public static void main(String[] args) {
		int opcao = 0;
		Scanner entrada = new Scanner(System.in);

		
		while(true) {
			System.out.println(
					"\n=> Escolha uma dentre as opções" + "\n1-Adicionar Aluno\n2-Remover "
							+ "Alunon\n3-Atualizar Aluno\n4-Listar Alunos\n0-Sair");
			try {
				opcao = entrada.nextInt();
				if(opcao != 0) {
					menu(opcao);
					break;
				}
				else
					entrada.close();
			} catch (InputMismatchException e) {
				entrada.nextLine();
				System.err.println("Digite um dos número!!!");
			}
			
		}
		
		

		
	}
	
	public static void menu(int opcao) {
		dao = new AlunoDAO(ConnectionFactory.getConection());
		List <Aluno> alunos;
		
		switch (opcao) {
		case 1:
			dao.adiciona(lerDados());
			break;
		case 2:
			dao.remove(PegarId());
			break;
		case 3:
			dao.adiciona(lerDados());
			break;
		case 4:
			alunos = dao.listaAlunos();
			exibeAlunos(alunos);
			break;
		default:
			System.out.println("Número incorreto!!!");
			break;
		}
		
	}
	
	public static Aluno PegarId() {
		Scanner entrada = new Scanner(System.in);
		Aluno aluno = new Aluno();
		Long id;
		
		while(true) {			
			try {
				System.out.println("\nForceça o id do aluno:");
				id = entrada.nextLong();
				entrada.close();
				break;
			} catch (InputMismatchException e) {
				entrada.nextLine();
				System.err.println("Dados inconpatíves !!!");
			}
		}
		
		aluno.setId(id);	
		return aluno;
	}
	
	public static void exibeAlunos(List<Aluno> alunos) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		
		for(Aluno aluno : alunos) {
			System.out.println(String.format("\nId = %d\nNome = %s\nEmail = %s\nEndereço = %s\n"
											+ "data de nacimento = %s ", aluno.getId(),aluno.getNome(),
											aluno.getEmail(),aluno.getEndereco(),df.format(aluno.getDataNascimento().getTime())));
		}
	}
	
	public static Aluno lerDados() {
		Scanner entrada = new Scanner(System.in);
		String nome, email, endereco, dataNacimento;	
		Aluno aluno = new Aluno();
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
				entrada.close();
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
