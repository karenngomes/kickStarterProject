package interfaces;

import models.KickStarter;

public class Main {

	public static void main(String[] args) {
		KickStarter kickStarter = new KickStarter();
		Menu menu = new Menu();
		
		Integer option = menu.main();
		while(option != 4){
			switch(option){
				case 1:
					System.out.println("1");
					break;
				case 2:
					menu.signIn(kickStarter);
					break;
				case 3:
					System.out.println("3");
					break;
				default:
					System.out.println("Opcao invalida, tente novamente!");
			}
			
			option = menu.main();
		}
		
	}

}
