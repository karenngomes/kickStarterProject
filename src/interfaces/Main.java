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
					menu.viewProjects(kickStarter);
					break;
				case 2:
					menu.signIn(kickStarter);
					if(kickStarter.getCurrentUser() != null) {
						Integer optionSignIn = menu.mainSignIn();
						while(optionSignIn != 6) {
							switch(optionSignIn){
								case 1:
									menu.viewProjects(kickStarter);
									break;
								case 2:
									menu.registerProject(kickStarter);
									break;
								case 3:
									menu.updateProject(kickStarter);
									break;
								case 4:
									menu.updateUser(kickStarter.getCurrentUser());
									break;
								case 5:
									menu.followUser(kickStarter);
									break;
								case 6:
									kickStarter.setCurrentUser(null);
									break;
								default:
									System.out.println("Opcao invalida, tente novamente!");
							}
						}
					}
					break;
				case 3:
					menu.registerUser(kickStarter);
					break;
				default:
					System.out.println("Opcao invalida, tente novamente!");
			}
			
			option = menu.main();
		}
		
	}

}
