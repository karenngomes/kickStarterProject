package interfaces;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import models.Category;
import models.Comment;
import models.CreditCard;
import models.KickStarter;
import models.Project;
import models.Reward;
import models.User;
import models.projects.Closed;
import models.projects.Progress;

public class Menu {
	private Scanner input;
	
	public Integer main() {
		input = new Scanner(System.in);
		
		System.out.println("\t ---- KickStarter");
		System.out.println("1. Visualizar projetos");
		System.out.println("2. Entrar no sistema");
		System.out.println("3. Cadastrar no sistema");
		System.out.println("4. Fechar");
		
		System.out.println("Digite uma opcao: ");
		return Integer.parseInt(input.nextLine());
	}
	
	public Integer mainSignIn() {
		input = new Scanner(System.in);
		
		System.out.println("\t ---- KickStarter");
		System.out.println("1. Visualizar projetos");
		System.out.println("2. Cadastrar novo projeto");
		System.out.println("3. Alterar informacoes do seu projeto");
		System.out.println("4. Alterar informacoes do seu perfil");
		System.out.println("5. Seguir usuario");
		System.out.println("6. Fechar");
		
		System.out.println("Digite uma opcao: ");
		return Integer.parseInt(input.nextLine());
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
	
	public void viewProjects(KickStarter ks) {
		input = new Scanner(System.in);
		try{
			for(Integer i = 0; i< 10;i++){
				Project project = ks.getListProjects().get(i);
				System.out.println("Nome do projeto: " + project.getName());
				System.out.println("Descricao do projeto: " + project.getDescription());
				System.out.println("Categoria: " + project.getCategory());
			}
		}catch(IndexOutOfBoundsException err){
			System.out.println("Nao possui mais projetos!");
		}
		
		System.out.println("Deseja ter mais informacoes de um projeto?\n\t1. SIM\n\t2. NAO");
		Integer option = Integer.parseInt(input.nextLine());
		while(option < 1 || option > 2){
			System.out.println("Digite uma opcao valida!");
			option = Integer.parseInt(input.nextLine());
		}
		
		if(option == 1){
			System.out.println("Informe o nome do projeto: ");
			String name = input.nextLine();
			Project project = ks.getProjectByName(name);
			if(project != null){
				System.out.println("Nome do projeto: " + project.getName());
				System.out.println("Descricao do projeto: " + project.getDescription());
				System.out.println("Categoria: " + project.getCategory());
				System.out.println("Valor Arrecadado: " + project.getCurrentMoney() + " / " +  project.getGoalMoney());
				System.out.println("Quantidade de contribuidores: " + project.getListContributors().size());
				Integer remainingDays = project.getDurationDays() - (Calendar.getInstance().get(Calendar.DAY_OF_YEAR) - project.getInitDay().get(Calendar.DAY_OF_YEAR));
				if(remainingDays < 0) {
					try{
						Closed closedProject = new Closed(project);
						ks.getListProjects().remove(project);
						ks.getListProjects().add(closedProject);
						project.getOwner().setBalanceAccount(project.getCurrentMoney() + project.getOwner().getBalanceAccount());
						
						System.out.println("Projeto ja foi encerrado a arrecadacao!");
					}catch(NullPointerException err) {
						System.out.println("Erro ao mudar status do projeto");
					}
					
				}else{
					System.out.println("Dias restantes: " + remainingDays);
				}
				
				System.out.println("\nRecompensas:");
				if(project.getListRewards().size() > 0){
					for(Reward reward : project.getListRewards()) {
						System.out.println("Nome: " + reward.getName());
						System.out.println("Descricao: " + reward.getDescription());
						System.out.println("Incluso:");
						for(String str : reward.getListIncludes()) {
							System.out.println("\t"+str);
						}
						System.out.println("Valor: R$" + reward.getPrice() + " ou mais");
						System.out.println("\nQuantidade de contribuintes: " + reward.getListCollaborators().size());
					}
				}else{
					System.out.println("Este projeto nao possui nenhuma recompensa.");
				}
				
				System.out.println("Comentarios:");
				for(Comment comment : project.getListComments()){
					System.out.println(comment.getSentUser() + " enviou: " + comment.getDescription());
					Date date = comment.getIssueDate().getTime();
					SimpleDateFormat formattedDate = new SimpleDateFormat("dd/MM/YYYY");
					System.out.println("Em " + formattedDate.format(date));
				}
				
				System.out.println("Deseja realizar alguma dessas opcoes referentes a este projeto: ");
				System.out.println("1. Investir no projeto");
				System.out.println("2. Escrever um comentario");
				System.out.println("3. Voltar");
				
				option = Integer.parseInt(input.nextLine());
				while(option < 1 || option > 3){
					System.out.println("Opcao invalida, digite novamente: ");
					option = Integer.parseInt(input.nextLine());
				}
				
				InputProjectInUser putProject = new InputProjectInUser(ks.getCurrentUser(),(Progress) project);
				
				switch(option){
					case 1:
						if(project instanceof Progress)
							investProject(putProject);
						else
							System.out.println("Nao e possivel investir neste projeto, ele ja foi encerrado!");
						break;
					case 2:
						if(project instanceof Progress) 
							addComment(putProject);
						else
							System.out.println("Nao e possivel comentar neste projeto, ele ja foi encerrado!");
						break;
				}
			}
		}
	}
	
	private void investProject(InputProjectInUser put) {
		input = new Scanner(System.in);
		
		User currentUser = put.getUser();
		
		if(currentUser != null) {
			try{
				System.out.println("Informe a quantia que deseja investir: ");
				Double investMoney = Double.parseDouble(input.nextLine());
				System.out.println("Informe o numero do cartao de credito que voce deseja utilizar: ");
				Integer numberCard = Integer.parseInt(input.nextLine());
				
				if(!currentUser.checkNumberCard(numberCard)){
					System.out.println("Voce nao possui este cartao previamente cadastrado, cadastre este cartao para poder investir no projeto.");
					return;
				}else {
					put.getProject().addContributor(currentUser, investMoney);
				}
			}catch(Exception exception) {
				System.out.println("So pode ser digitado numeros!");
			}
			
		}else {
			System.out.println("Voce precisa estar logado para efetuar um investimento!");
		}
	}
	
	private void addComment(InputProjectInUser put) {
		input = new Scanner(System.in);
		
				if(put.getUser() != null) {
			System.out.println("Informe o comentario que deseja fazer:");
			String description = input.nextLine();
			put.getProject().addComment(new Comment(description, Calendar.getInstance(), put.getUser()));
		}else{
			System.out.println("Voce precisa estar logado para efetuar um investimento!");
		}
	}
	
	public void registerUser(KickStarter ks) {
		input = new Scanner(System.in);
		
		System.out.println("\t CADASTRAR NOVO USUARIO\n");
		System.out.println("Informe o seu nome: ");
		String name = input.nextLine();
		System.out.println("Informe seu email: ");
		String email = input.nextLine();
		System.out.println("Informe a senha que voce deseja: ");
		String password = input.nextLine();
		
		ks.addUser(name, email, password);
		
	}
	
	public void registerProject(KickStarter ks) {
		input = new Scanner(System.in);
		
		System.out.println("\t CADASTRAR NOVO PROJETO\n");
		System.out.println("Informe o nome do projeto: ");
		String name = input.nextLine();
		while(!ks.checkProjectName(name)){
			System.out.println("Este nome de projeto ja existe informe outro:");
			name = input.nextLine();
		}
		System.out.println("Informe a descricao do projeto: ");
		String description = input.nextLine();
		Category category = getCategoryByNumber();
		System.out.println("Informe a quantidade de dias para arrecadacao do projeto: ");
		Integer durationDays = Integer.parseInt(input.nextLine());
		System.out.println("Informe a quantia que deseja arrecadar: ");
		Double goalMoney = Double.parseDouble(input.nextLine());
		ks.addProject(new Progress(ks.getCurrentUser(), category, name, description, durationDays, goalMoney));
		
	}
	
	public void updateProject(KickStarter ks) {
		input = new Scanner(System.in);
		
		System.out.println("Informe o nome do projeto que deseja alterar: ");
		String name = input.nextLine();
		String rewardName;
		
		for(Project project : ks.getListProjects()) {
			if(project.getOwner().equals(ks.getCurrentUser()) && project.getName().equals(name)){
				if(project instanceof Progress){
					System.out.println("Voce Deseja alterar que informacao: ");
					System.out.println("1. Descricao");
					System.out.println("2. Adicionar recompensa");
					System.out.println("3. Remover recompensa");
					System.out.println("4. Quantia a ser arrecadada");
					System.out.println("5. Fechar");
					
					System.out.println("Informe a opcao que deseja:");
					Integer option = Integer.parseInt(input.nextLine());
					while(option < 1 || option > 5){
						System.out.println("Opcao invalida, digite novamente:");
						option = Integer.parseInt(input.nextLine());
					}
					
					switch(option) {
						case 1:
							System.out.println("Informe a nova descricao:");
							project.setDescription(input.nextLine());
							break;
						case 2:
							System.out.println("Informe o nome da nova recompensa:");
							rewardName = input.nextLine();
							System.out.println("Informe uma descricao para a nova recompensa:");
							String description = input.nextLine();
							System.out.println("Informe uma quantia para atingir a recompensa:");
							Double price = Double.parseDouble(input.nextLine());
							
							ArrayList<String> includes = new ArrayList<String>();
							Boolean flag = true;
							Integer optionIncludes;
							while(flag) {
								System.out.println("Deseja adicionar um item a ser incluso na recompensa?\n\t1. Sim\n\t2. Nao");
								optionIncludes = Integer.parseInt(input.nextLine());
								while(optionIncludes < 1 || optionIncludes > 2){
									System.out.println("Opcao invalida, digite novamente:");
									optionIncludes = Integer.parseInt(input.nextLine());
								}
								if(optionIncludes == 1){
									System.out.println("Informe o nome do item: ");
									includes.add(input.nextLine());
								}else{
									flag = false;
								}
							}
							
							((Progress) project).addReward(new Reward(rewardName, description, price, includes));
							break;
						case 3:
							System.out.println("Informe o nome da recompensa que deseja remover: ");
							rewardName = input.nextLine();
							((Progress) project).removeReward(rewardName);
							break;
						case 4:
							System.out.println("Informe a nova quantia a ser arrecadada:");
							project.setGoalMoney(Double.parseDouble(input.nextLine()));
							break;
					}
				}else{
					System.out.println("Este projeto ja foi encerrado!");
				}
			}else{
				System.out.println("Voce nao possui nenhum projeto com este nome");
			}
		}
	}
	
	public void updateUser(User user) {
		input = new Scanner(System.in);
		Integer option;
		
		System.out.println("\tAlterar informacoes do usuario\n");
		
		System.out.println("Deseja qual dessas opcoes:");
		System.out.println("\t1. Alterar nome de exibicao");
		System.out.println("\t2. Alterar sua biografia");
		System.out.println("\t3. Alterar sua localidade");
		System.out.println("\t4. Adicionar cartao de credito");
		System.out.println("\t5. Voltar");
		
		System.out.println("Informe a opcao que deseja: ");
		
		try{
			option = Integer.parseInt(input.nextLine());

			while(option < 1 || option > 5){
				System.out.println("Opcao invalida, digite novamente:");
				option = Integer.parseInt(input.nextLine());
			}
		}catch(NumberFormatException err) {
			throw err;
		}
		
		
		switch(option) {
			case 1:
				System.out.println("Informe o novo nome:");
				user.setName(input.nextLine());
				break;
			case 2:
				System.out.println("Informe a nova biografia:");
				user.getProfile().setBiography(input.nextLine());
				break;
			case 3:
				System.out.println("Informe a sua nova localidade:");
				user.getProfile().setLocation(input.nextLine());
				break;
			case 4:
				System.out.println("\tADICIONAR NOVO CARTAO DE CREDITO\n");
				Integer numberCard,password, expiredMonth, expiredYear;

				try{
					System.out.println("Digite o numero do cartao de credito:");
					numberCard = Integer.parseInt(input.nextLine());
				}catch(NumberFormatException err){
					System.out.println("O numero do cartao deve ser somente numeros");
					throw err;
				}
				
				
				try{
					System.out.println("Informe a senha do cartao:");
					password = Integer.parseInt(input.nextLine());
				}catch(NumberFormatException err) {
					System.out.println("A senha deve ser somente numeros");
					throw err;
				}
				
				System.out.println("Informe o nome impresso no cartao:");
				String holderName = input.nextLine();
				
				try{
					System.out.println("Informe o mes que o cartao expira:");
					expiredMonth = Integer.parseInt(input.nextLine());
					
					System.out.println("Informe o ano que o cartao expira:");
					expiredYear = Integer.parseInt(input.nextLine());
				}catch(NumberFormatException err){
					System.out.println("Deve ser somente numeros.");
					throw err;
				}
				
				CreditCard creditCard = new CreditCard(numberCard, password, holderName, expiredMonth, expiredYear);
				user.addCreditCard(creditCard);
		}
		
	}
	
	public void followUser(KickStarter ks) {
		input = new Scanner(System.in);
		
		System.out.println("Informe o email do usuario que deseja seguir:");
		String email = input.nextLine();
		if(ks.checkUserByEmail(email)){
			if(ks.getCurrentUser().checkFollowing(email)){
				ks.getCurrentUser().addFollower(ks.getUserByEmail(email));
			}
		}
		
	}
	
	@SuppressWarnings("null")
	private Category getCategoryByNumber(){
		input = new Scanner(System.in);
		
		System.out.println("Informe a categoria do seu projeto: ");
		System.out.println("\t1. Artes");
		System.out.println("\t2. Comics ou ilustracoes");
		System.out.println("\t3. Design ou Tecnologia");
		System.out.println("\t4. Filmes");
		System.out.println("\t5. Comida ou Artesanato");
		System.out.println("\t6. Jogos");
		System.out.println("\t7. Musicas");
		System.out.println("\t8. Publicidade");
		
		System.out.println("Informe sua opcao:");
		Integer option = Integer.parseInt(input.nextLine());
		while(option < 1 || option > 8) {
			System.out.println("Opcao invalida, digite novamente");
			option = Integer.parseInt(input.nextLine());
		}
		
		Category category = null;
		
		return category.selectByNumber(option);
		
	}
	
}
