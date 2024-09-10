# 🔒 Encriptação de Senha
Uma API desenvolvida em Spring Boot para armazenamento seguro de e-mails e senhas de usuários, utilizando MySQL como banco de dados.

## 🚀 Funcionalidades
* Cadastro de Usuários: Armazena e-mails e senhas de forma segura.
* Encriptação de Senhas: As senhas são criptografadas antes de serem armazenadas no banco de dados, garantindo que estejam protegidas contra acessos não autorizados.
* Validação de Usuário: Verifica se o e-mail e a senha fornecidos correspondem aos dados armazenados.
## 🛠️ Tecnologias Utilizadas
* Spring Boot: Framework principal para construção da API.
* MySQL: Banco de dados relacional para armazenamento das informações dos usuários.
* Spring Security: Implementa a encriptação e outras funcionalidades de segurança.
* JPA/Hibernate: Para o mapeamento objeto-relacional e gerenciamento dos dados.
## 📚 Pré-requisitos
Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:

Java 11 ou superior

Maven

MySQL

## Documentação da API

### Retorna todos os usuarios

```http
  GET http://localhost:8080/usuario/all
```

#### Exemplo da resposta
```
[
	{
		"id": 1,
		"email": "teste@gmail.com",
		"senha": "$2a$10$STzP4Dd0QnM/xqMrkS28aeA86sNfN4kkg4lE6lOG0Ap1LCdypAE.u"
	},
	{
		"id": 2,
		"email": "zezinho@gmail.com",
		"senha": "$2a$10$b0GSzYEfjGY1si1bE0PAg.xGJfAOz9mjoZNtjKEk7cwpusaZXFCjS"
	}
]
```
___

### Cria um novo usuário

```http
  POST http://localhost:8080/usuario/salvar
```

| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `string` | **Obrigatório**. Email do usuario |
| `senha`      | `string` | **Obrigatório**. Senha do usuario |

#### Exemplo corpo da requisição
```
  {
	  "email":"zezinho@gmail.com",
	  "senha": 1234
  }
```

#### Exemplo da resposta
```
  {
    "id": 2,
    "email": "zezinho@gmail.com",
    "senha": "$2a$10$b0GSzYEfjGY1si1bE0PAg.xGJfAOz9mjoZNtjKEk7cwpusaZXFCjS"
  }
```
### Login do usuario

```http
  GET http://localhost:8080/usuario/login
```
| Parâmetro   | Tipo       | Descrição                                   |
| :---------- | :--------- | :------------------------------------------ |
| `email`      | `string` | **Obrigatório**. Email do usuario |
| `senha`      | `string` | **Obrigatório**. Senha do usuario |

#### Exemplo corpo da requisição
```
  {
	  "email":"zezinho@gmail.com",
	  "senha": 1234
  }
```

#### Exemplo da resposta
```
  {
    "id": 2,
    "email": "zezinho@gmail.com",
    "senha": "$2a$10$b0GSzYEfjGY1si1bE0PAg.xGJfAOz9mjoZNtjKEk7cwpusaZXFCjS"
  }
```
