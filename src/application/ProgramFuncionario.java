package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entitites.Funcionario;

public class ProgramFuncionario {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		List<Funcionario> lista = new ArrayList<>();
		
		System.out.print("Quantos funcionarios para cadastro ? ");
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			System.out.println("Funcionario #" + (i+1) + ":");
			System.out.print("ID: ");
			int id = sc.nextInt();
			while(testeId(lista, id)) {
				System.out.println("Id ja existente, escreva outro");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String nome = sc.nextLine();
			System.out.print("Salario: ");
			double salario = sc.nextDouble();
			Funcionario func = new Funcionario(id, nome, salario);
			lista.add(func);
		}
		
		System.out.print("Id do funcionario a ser aumentado o salario: ");
		int id = sc.nextInt();
		
		/*
		Integer pos = posicao(lista, id);
		
		if(pos == null) {
			System.out.println("Esse funcionario nao existe!");
		}else {
			System.out.print("Qual a porcentagem para aumento ? ");
			double porcentagem = sc.nextDouble();
			lista.get(pos).aumentoSalario(porcentagem);
		}
		*/
		Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		
		if(func == null) {
			System.out.println("Esse funcionario nao existe!");
		}else {
			System.out.print("Qual a porcentagem para aumento ? ");
			double porcentagem = sc.nextDouble();
			func.aumentoSalario(porcentagem);
		}
		
		for(Funcionario x : lista) {
			System.out.println(x.toString());
		}
		
		sc.close();
		
	}

	public static Integer posicao(List<Funcionario> lista, int id) {
		for(int i = 0; i < lista.size(); i++) {
			if(lista.get(i).getId() == id) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean testeId(List<Funcionario> lista, int id) {
		Funcionario func = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return func != null;
	}
}
