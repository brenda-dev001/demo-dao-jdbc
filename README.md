# ☕ Demo DAO JDBC

Projeto desenvolvido durante meus estudos de Java, acompanhando um curso da Udemy, com foco na integração entre Java e banco de dados utilizando JDBC e no padrão de projeto DAO.

## ✨ Funcionalidades

- Busca de vendedores por ID.
- Listagem de todos os vendedores.
- Busca de vendedores por departamento.
- Cadastro, atualização e exclusão de vendedores.
- Busca e listagem de departamentos.
- Cadastro, atualização e exclusão de departamentos.
- Integração com banco de dados utilizando JDBC.
- Recuperação automática dos IDs gerados pelo banco de dados.

## 🛠️ Tecnologias utilizadas

<p align="center">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/java/java-original.svg" width="40" height="40" alt="Java" title="Java" />
  &nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/mysql/mysql-original.svg" width="40" height="40" alt="MySQL" title="MySQL" />
  &nbsp;
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon@latest/icons/maven/maven-original.svg" width="40" height="40" alt="Maven" title="Maven" />
  &nbsp;
</p>

## ⚙️ Como o projeto funciona

O projeto utiliza Java JDBC para executar operações SQL em um banco de dados relacional.

A organização segue o padrão DAO (*Data Access Object*), separando as operações de acesso aos dados das classes que representam as entidades do sistema.

As principais entidades são `Seller` e `Department`, relacionadas entre si por meio do departamento de cada vendedor.

## 📁 Estrutura do projeto

```text
demo-dao-jdbc/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/example/
│   │   │       ├── application/
│   │   │       │   └── Program.java
│   │   │       ├── db/
│   │   │       └── model/
│   │   │           ├── dao/
│   │   │           └── entities/
│   │   └── resources/
│   └── test/
├── db.properties
├── pom.xml
└── .gitignore
```

## 🚀 Executando o projeto

1. Tenha o Java e o banco de dados MySQL instalados.
2. Configure a conexão com o banco de dados no arquivo `db.properties`.
3. Crie o banco de dados e as tabelas necessárias.
4. Abra o projeto em uma IDE compatível com Java, como IntelliJ IDEA.
5. Execute a classe `Program.java` para testar as operações implementadas.

## 📌 Status do projeto

Projeto desenvolvido para fins de estudo e prática dos conceitos de Java, JDBC, SQL e padrão DAO.

## 👩‍💻 Autoria

Desenvolvido por [Brenda](https://github.com/brenda-dev001), acompanhando um curso de Java da Udemy.
