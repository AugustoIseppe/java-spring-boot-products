# 🚀 API RESTful de Produtos e Categorias 🛍️

## 📝 Descrição

Bem-vindo à API RESTful de Produtos e Categorias! 🎉 Este projeto consiste em uma API robusta desenvolvida com Spring Boot, projetada para gerenciar produtos e suas respectivas categorias. A aplicação implementa um CRUD completo para ambas as entidades, permitindo criar, ler, atualizar e deletar produtos e categorias, além de gerenciar o relacionamento Muitos-para-Muitos entre eles. É uma excelente demonstração de habilidades em desenvolvimento backend com Java e o ecossistema Spring, ideal para portfólios e avaliação de recrutadores. 🧐

## ✨ Funcionalidades Principais

Esta API oferece um conjunto completo de operações CRUD (Criar, Ler, Atualizar, Deletar) para gerenciar produtos e categorias:

*   **Produtos:** 📦
    *   Criar novos produtos com nome, valor, descrição, URL de imagem e associação a categorias.
    *   Listar todos os produtos cadastrados.
    *   Buscar um produto específico pelo seu ID.
    *   Atualizar informações de um produto existente.
    *   Deletar um produto.
*   **Categorias:** 🏷️
    *   Criar novas categorias.
    *   Listar todas as categorias.
    *   Buscar uma categoria específica pelo seu ID.
    *   Atualizar o nome de uma categoria.
    *   Deletar uma categoria.
*   **Relacionamento:** 🔗
    *   Associação flexível Muitos-para-Muitos entre produtos e categorias.
    *   Consulta de produtos por categoria e categorias por produto (implícito através das listagens e buscas).

## 🛠️ Tecnologias Utilizadas

Este projeto foi construído utilizando as seguintes tecnologias e ferramentas:

*   **Linguagem:** Java 21 ☕
*   **Framework:** Spring Boot 3.4.5 🌱 (Conforme `pom.xml`)
*   **Persistência de Dados:** Spring Data JPA / Hibernate 💾
*   **Banco de Dados:** PostgreSQL 🐘
*   **Validação:** Spring Boot Starter Validation ✅
*   **Servidor Web:** Tomcat (embutido no Spring Boot) 🌐
*   **Gerenciador de Dependências:** Maven 📦

## ⚙️ Configuração do Ambiente

Siga os passos abaixo para configurar e executar o projeto localmente:

### Pré-requisitos

*   **Java Development Kit (JDK):** Versão 21 ou superior instalada. ☕
*   **Maven:** Instalado e configurado no seu PATH. 📦
*   **PostgreSQL:** Instância do PostgreSQL rodando. 🐘 (Você pode usar Docker para facilitar! 🐳)
*   **IDE (Opcional):** IntelliJ IDEA, Eclipse, VS Code com extensões Java/Spring. 💻

### Configuração do Banco de Dados

1.  **Crie o Banco de Dados:** Certifique-se de que você tenha um banco de dados PostgreSQL chamado `produtos-apirestful` criado.
    ```sql
    CREATE DATABASE "produtos-apirestful";
    ```
2.  **Configure as Credenciais:** Atualize o arquivo `src/main/resources/application.properties` com as suas credenciais do PostgreSQL. O arquivo deve conter as seguintes propriedades (ajuste os valores conforme necessário):
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/produtos-apirestful
    spring.datasource.username=SEU_USUARIO_POSTGRES # Use 'postgres' se for o padrão
    spring.datasource.password=SUA_SENHA_POSTGRES # Use '123123' conforme informado ou a sua senha
    spring.jpa.hibernate.ddl-auto=update # Cria/atualiza tabelas automaticamente ao iniciar
    spring.jpa.show-sql=true # Mostra SQLs gerados no console (bom para debug)
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```

### Executando a Aplicação

1.  **Clone o Repositório:**
    ```bash
    git clone <URL_DO_SEU_REPOSITORIO>
    cd products-api-restful
    ```
2.  **Compile e Execute com Maven:**
    ```bash
    mvn spring-boot:run
    ```
3.  **Acesse a API:** A aplicação estará rodando em `http://localhost:8080` (ou a porta configurada). 🚀

## 📄 Endpoints da API (Exemplos)

A API segue os padrões RESTful. Abaixo estão alguns exemplos de endpoints (substitua `{id}` pelo ID correspondente):

**Produtos** 📦

*   `POST /products` - Cria um novo produto.
    *   *Corpo da Requisição (Exemplo):*
        ```json
        {
          "name": "Notebook Gamer Pro",
          "value": 7500.00,
          "description": "Notebook de alta performance para jogos.",
          "imgUrl": "http://example.com/notebook.jpg",
          "categories": [ { "id": "uuid-da-categoria-1" }, { "id": "uuid-da-categoria-2" } ]
        }
        ```
*   `GET /products` - Lista todos os produtos.
*   `GET /products/{id}` - Busca um produto pelo ID.
*   `PUT /products/{id}` - Atualiza um produto existente.
    *   *Corpo da Requisição (similar ao POST)*
*   `DELETE /products/{id}` - Deleta um produto.

**Categorias** 🏷️

*   `POST /categories` - Cria uma nova categoria.
    *   *Corpo da Requisição (Exemplo):*
        ```json
        {
          "name": "Eletrônicos"
        }
        ```
*   `GET /categories` - Lista todas as categorias.
*   `GET /categories/{id}` - Busca uma categoria pelo ID.
*   `PUT /categories/{id}` - Atualiza uma categoria existente.
    *   *Corpo da Requisição (similar ao POST)*
*   `DELETE /categories/{id}` - Deleta uma categoria.

*Observação:* Recomenda-se usar ferramentas como Postman ou Insomnia para testar os endpoints. 🔧

## 🤝 Como Contribuir

Contribuições são bem-vindas! Se você encontrar algum bug ou tiver sugestões de melhorias, sinta-se à vontade para abrir uma *issue* ou enviar um *pull request*. ✨

1.  Faça um *fork* do projeto.
2.  Crie uma nova *branch* (`git checkout -b feature/sua-feature`).
3.  Faça commit das suas alterações (`git commit -m 'Adiciona nova feature'`).
4.  Faça *push* para a *branch* (`git push origin feature/sua-feature`).
5.  Abra um *Pull Request*.

## 👨‍💻 Desenvolvedor

Desenvolvido com ❤️ por [Seu Nome/Apelido Aqui]!

*   **LinkedIn:** [Link para seu LinkedIn] 🔗
*   **GitHub:** [Link para seu GitHub] 🐙
*   **Email:** [Seu Email de Contato] 📧

---

*Este README foi gerado com o auxílio de IA para garantir as melhores práticas e um formato atraente.* 😉

