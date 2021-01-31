package br.edu.barbacena.ifsudestemg.daw.teste;

import java.util.List;
import java.util.Scanner;

import br.edu.barbacena.ifsudestemg.daw.dao.ProfessorDAO;
import br.edu.barbacena.ifsudestemg.daw.modelo.Professor;

public class TestarProfessorDAO {

	private ProfessorDAO dao;
	private Scanner entrada;
	
	public static void main(String[] args) {
		new TestarProfessorDAO();
	}

	public TestarProfessorDAO() {
		dao = new ProfessorDAO();
		entrada = new Scanner(System.in);
		inicializa();
	}
	
	public void  inicializa() {
		int opcao = 0;

		while (true) {
			System.out.println("\n=> Escolha uma dentre as opções" + "\n1-Adicionar Professor\n2-Remover "
					+ "Professor\n3-Atualizar Professor\n4-Listar Professor\n0-Sair");
			try {
				opcao = Integer.parseInt(entrada.nextLine());
				if (opcao != 0) {
					menu(opcao);
				} else {
					entrada.close();
					break;
				}
			} catch (NumberFormatException e) {
				entrada.nextLine();
				System.err.println("Digite um número!!!");
			}

		}
	}
	
	public void menu(int opcao) {
		Professor professor = new Professor();
		
		switch (opcao) {
		case 1:
			dao.adiciona(lerDados(professor));
			break;
		case 2:
			dao.remove(PegarId());
			break;
		case 3:
			dao.altera(lerDados(PegarId()));
			break;
		case 4:
			exibeProfessor(dao.listaProfessores());
			break;
		default:
			System.out.println("Número incorreto!!!");
			break;
		}

	}

	public Professor PegarId() {
		Professor professor = new Professor();
		Long id;

		while (true) {
			try {
				System.out.println("\nForceça o id do professor:");
				id = Long.parseLong(entrada.nextLine());
				break;
			} catch (NumberFormatException e) {
				entrada.nextLine();
				System.err.println("Dados inconpatíves !!!");
			}
		}

		professor.setId(id);
		return professor;
	}

	public void exibeProfessor(List<Professor> professores) {

		for (Professor porfessor : professores) {
			System.out.println(
					String.format("\nId = %d\nNome = %s\nGrau de Formação = %s",
							porfessor.getId(), porfessor.getNome(),porfessor.getGrauFormacao()));
		}
	}

	public Professor lerDados(Professor professor) {
		String nome, email, grauFormacao;
		System.out.println("\nForceça o os dados do professor: nome, email, grau de formação respectivamente:");
	
		nome = entrada.nextLine();
		email = entrada.nextLine();
		grauFormacao = entrada.nextLine();
		
		professor.setNome(nome);
		professor.setEmail(email);
		professor.setGrauFormacao(grauFormacao);

		return professor;

	}
}
