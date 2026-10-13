# API de Biblioteca

API REST desenvolvida com Spring Boot para gerenciamento de acervo literário e administração de usuários de uma biblioteca.

## 🚀 Sobre o Projeto

Este projeto foi desenvolvido com o objetivo de aplicar conceitos de desenvolvimento de APIs REST, arquitetura em camadas e integração com banco de dados relacional utilizando Spring Data JPA.

A aplicação permite cadastrar e consultar livros, além de gerenciar atendentes (operadores do sistema) e clientes (usuários do acervo), garantindo que as regras de integridade dos dados sejam respeitadas diretamente na camada de persistência.

---


# 📊 Funcionalidades

## 📚 Livros

* Cadastro de livros;
* Listagem e busca por ID;
* Atualização e exclusão;
* Categorização por gênero literário (enumeração).

## 🧑‍💼 Atendentes

* Cadastro de atendentes;
* Listagem e busca por ID;
* Atualização e exclusão;
* E-mail único por atendente.

## 👤 Clientes

* Cadastro de clientes;
* Listagem e busca por ID;
* Atualização e exclusão;
* Registro de dados de contato (e-mail e telefone).

## ⚠️ Tratamento de Erros

* Respostas de erro padronizadas em JSON (timestamp, status, erro e mensagem);
* Tratamento global de exceções com `@RestControllerAdvice`.

---


# 🌐 Como a API Funciona

A aplicação roda localmente na porta padrão do Spring Boot e expõe os recursos por meio de URLs, utilizando os métodos HTTP e trocando dados no formato JSON.

**URL base:** `http://localhost:8080`

## 🔗 Endpoints

| Recurso    | Método | URL                                  | Descrição                    |
| ---------- | ------ | ------------------------------------ | ---------------------------- |
| Home       | GET    | `http://localhost:8080/`             | Verifica se a API está no ar |
| Livros     | GET    | `http://localhost:8080/livro`        | Lista todos os livros        |
| Livros     | GET    | `http://localhost:8080/livro/{id}`   | Busca livro por ID           |
| Livros     | POST   | `http://localhost:8080/livro`        | Cadastra um livro            |
| Livros     | PUT    | `http://localhost:8080/livro/{id}`   | Atualiza um livro            |
| Livros     | DELETE | `http://localhost:8080/livro/{id}`   | Remove um livro              |
| Atendentes | GET    | `http://localhost:8080/atendente`    | Lista todos os atendentes    |
| Atendentes | GET    | `http://localhost:8080/atendente/{id}` | Busca atendente por ID     |
| Atendentes | POST   | `http://localhost:8080/atendente`    | Cadastra um atendente        |
| Atendentes | PUT    | `http://localhost:8080/atendente/{id}` | Atualiza um atendente      |
| Atendentes | DELETE | `http://localhost:8080/atendente/{id}` | Remove um atendente        |
| Clientes   | GET    | `http://localhost:8080/cliente`      | Lista todos os clientes      |
| Clientes   | GET    | `http://localhost:8080/cliente/{id}` | Busca cliente por ID         |
| Clientes   | POST   | `http://localhost:8080/cliente`      | Cadastra um cliente          |
| Clientes   | PUT    | `http://localhost:8080/cliente/{id}` | Atualiza um cliente          |
| Clientes   | DELETE | `http://localhost:8080/cliente/{id}` | Remove um cliente            |


## 🔄 Métodos HTTP e Operações (CRUD)


| Método HTTP | Operação | Uso na API                                  |
| ----------- | -------- | ------------------------------------------- |
| `GET`       | Read     | Consultar um registro ou listar todos       |
| `POST`      | Create   | Criar um novo registro (dados no corpo JSON) |
| `PUT`       | Update   | Atualizar um registro existente pelo `id`   |
| `DELETE`    | Delete   | Remover um registro pelo `id`               |


## 📡 Códigos de Status HTTP


| Código | Significado           | Quando ocorre                                   |
| ------ | --------------------- | ----------------------------------------------- |
| 400    | Bad Request           | Dados enviados são inválidos                    |
| 404    | Not Found             | Registro com o `id` informado não existe        |
| 409    | Conflict              | Já existe um registro com os mesmos dados       |
| 500    | Internal Server Error | Erro inesperado no servidor                     |


# 🗃️ Modelo de Domínio


| Entidade  | Tabela       | Atributos                                         | Restrições                                              |
| --------- | ------------ | ------------------------------------------------- | ------------------------------------------------------- |
| Atendente | `Atendentes` | id, nome, email, password                         | id com geração `IDENTITY`; email único; todos não nulos |
| Cliente   | `clientes`   | id, nome, email, telefone, password               | id com geração `IDENTITY`; todos não nulos              |
| Livro     | `livros`     | id, titulo, autor, editora, anoPublicacao, genero | id com geração `IDENTITY`; todos não nulos              |

* O atributo `genero` é uma enumeração (`Genero`) persistida como **String** (`EnumType.STRING`), o que facilita a leitura das consultas SQL e evita problemas caso a ordem dos valores seja alterada no código;
* O atributo `anoPublicacao` é um inteiro (`int`).

---

# 🛠️ Tecnologias Utilizadas

* Java 17
* Spring Boot 4.1.1
* Spring Web MVC
* Spring Data JPA / Hibernate
* PostgreSQL
* Lombok
* Maven
* Postman (testes dos endpoints)

---
