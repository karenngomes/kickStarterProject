# Kickstarter Project

> O kickstarter é um dos maiores sites do mundo de investimento coletivo, 
> ele tem como objetivo apoiar projetos inovadores dando visibilidade
> para milhares de pessoas que poderão contribuir com qualquer quantia
> em dinheiro para que o projeto atinja seu objetivo.
***

### Classes

#### User
| Atributos |
| ------ |
| id : Integer |
| name : String |
| email : String |
| password : String |
| listCreditCards : ArrayList< CreditCard > |
| profile : Profile |
| balanceAccount : Double |

#### CreditCard
| Atributos |
| ------ |
| id : Integer |
| numberCard : Integer |
| holderName : String |
| expiredDate : Calendar |

#### Profile
| Atributos |
| ------ |
| id : Integer |
| biography : String |
| location : String |
| listFollowers : ArrayList< User > |
  
#### Reward
| Atributos |
| ------ |
| id : Integer |
| name : String |
| description : String |
| listIncludes : ArrayList< String > |
| price : Double |
  
#### Comment
| Atributos |
| ------ |
| id : Integer |
| description : String |
| issueDate : Calendar |
| sentUser : User |

#### Project
| Atributos |
| ------ |
| id : Integer |
| category : Category |
| owner : User |
| description : String |
| duration : Integer |
| currentMoney : Double |
| goalMoney : Double |
| listContributors : ArrayList< User > |
| listRewards : ArrayList< Reward > |
| listComments : ArrayList< Comment > |

Projetos podem estar encerrados ou em andamento
  
#### Categories
| Types of Projects |
| ------ |
| Film |
| Design & Tech |
| Food & Craft |
| Publishing |
| Games |
| Music |
| Comics & Illustration |
| Arts |

#### kickStarter
| Atributos |
| ------ |
| listUsers : ArrayList< User > |
| listProjects : ArrayList< Project > |

### Funcionalidades do sistema

| Função | Descrição |
| ------ | ------ |
| Cadastrar Usuário | Fazer o cadastro de um usuário que terão como atributos básicos: nome, email e senha |
| Editar Perfil | Um usuário pode alterar seus dados de cadastro e também adicionar uma biografia e localização |
| Cadastrar Projeto | Um usuário pode criar seu projeto que possuirão uma categoria, uma descrição, o usuário deve ter no mínimo 18 anos, ter uma conta bancária no país de origem e um cartão de crédito |
| Editar Projeto | O dono do projeto é capaz de alterar informações do seu projeto |
| Investir no Projeto | Um usuário pode investir em qualquer projeto de seu interesse com qualquer quantia em dinheiro |
| Listar projetos | Lista todos os projetos atuais, separados pelas categoria |
| Adicionar recompensa | O dono do projeto é capaz de adicionar recompensas |
| Adicionar comentários | Os usuários podem adicionar comentários ao projeto |
| Cadastrar cartão de crédito | O usuário é capaz de adicionar as informações do seu cartão de crédito |
| Seguir usuário | Um usuário é capaz de seguir outro usuário |

