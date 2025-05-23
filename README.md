# Projeto Spring Boot - API de Funcionários

Este é um projeto Spring Boot que implementa uma API REST para gerenciamento de funcionários e seus endereços.

## Estrutura do Projeto

O projeto segue a estrutura padrão de um projeto Spring Boot:

- `src/main/java/com/example/funcionarioapi/model`: Classes de modelo (Funcionario e Endereco)
- `src/main/java/com/example/funcionarioapi/repository`: Interfaces de repositório
- `src/main/java/com/example/funcionarioapi/controller`: Controladores REST
- `src/main/java/com/example/funcionarioapi/exception`: Classes para tratamento de exceções

## Endpoints da API

- `GET /funcionarios`: Lista todos os funcionários
- `GET /funcionarios/{id}`: Retorna um funcionário específico pelo ID
- `POST /funcionarios`: Cria um novo funcionário
- `PUT /funcionarios/{id}`: Atualiza um funcionário existente
- `DELETE /funcionarios/{id}`: Remove um funcionário

## Como Executar

1. Importe o projeto no Spring Tool Suite
2. Execute como uma aplicação Spring Boot
3. Acesse a API em `http://localhost:8080/funcionarios`
4. O console H2 está disponível em `http://localhost:8080/h2-console`

## Tecnologias Utilizadas

- Spring Boot 2.7.12
- Spring Data JPA
- Validation API
- H2 Database
- Maven
