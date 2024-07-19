# Livraria Virtual

## Introdução

Este projeto consiste em implementar um sistema de gerenciamento de uma livraria virtual, explorando os conceitos de
composição, herança e polimorfismo.

## Tecnologias Utilizadas

- Maven
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Boot Devtools
- Lombok
- Flyway Migration
- Spring HATEOAS

## Estrutura do Projeto

O projeto segue a estrutura MVC (Model-View-Controller) para organizar o código de maneira limpa e escalável.

## Descrição do Sistema

O sistema oferece as seguintes funcionalidades:

- **Cadastrar livro**: Permite ao usuário cadastrar um livro.
- **Realizar uma venda**: Permite ao usuário realizar a venda de um ou mais livros.
- **Listar livros**: Lista todos os livros cadastrados, sejam eletrônicos ou impressos.
- **Listar vendas**: Lista todas as vendas realizadas.
- **Sair do programa**: Encerra a execução do programa.

## Classes e Atributos

### Livro

Classe abstrata com os atributos:

- `titulo`: Título do livro
- `autores`: Nome do autor ou dos autores do livro
- `editora`: Nome da editora do livro
- `preco`: Preço do livro

### Impresso

Representa um livro impresso com os atributos:

- `frete`: Frete cobrado para entrega do livro
- `estoque`: Número de exemplares do livro em estoque

### Eletronico

Representa um livro eletrônico com o atributo:

- `tamanho`: Tamanho do arquivo eletrônico do livro em KB

### Venda

Representa uma venda com os atributos:

- `livros`: Vetor de referências a objetos do tipo Livro
- `numVendas`: Quantidade de vendas realizadas
- `numero`: Número da venda
- `cliente`: Nome do cliente que comprou o(s) livro(s)
- `valor`: Valor total da venda

### LivrariaVirtual

Classe principal que gerencia o sistema de livraria virtual com métodos para cadastrar livros, realizar vendas, listar
livros e listar vendas.

## Configuração do Flyway

Scripts de migração Flyway estão localizados em `src/main/resources/db/migration`.

## Executando o Projeto

Para executar o projeto, utilize o comando:

```bash
mvn spring-boot:run
