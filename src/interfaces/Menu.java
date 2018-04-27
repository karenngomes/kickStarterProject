package interfaces;

import java.util.Scanner;

import models.KickStarter;
import models.User;

public class Menu {
	private Scanner input;
	
	public Integer main() {
		input = new Scanner(System.in);
		
		System.out.println("\t ---- KickStarter");
		System.out.println("1. Visualizar projetos");
		System.out.println("2. Entrar no sistema");
		System.out.println("3. Cadastrar no sistema");
		System.out.println("4. Close");
		
		System.out.println("Digite uma opcao: ");
		Integer option = Integer.parseInt(input.nextLine());
		return option;
	}
	
	public void signIn(KickStarter ks){
		input = new Scanner(System.in);
				
		
		System.out.println("Digite seu email: ");
		String email = input.nextLine();
		System.out.println("Digite sua senha: ");
		String password = input.nextLine();
		
		User user = ks.signIn(email,password);
		
		if(user == null)
			System.out.println("Email ou senha invalido!");
		else
			ks.setCurrentUser(user);
	}
	
}
