# 🚀 Sistema de Gerenciamento de Funcionários

API REST desenvolvida em Java utilizando Spring Boot para gerenciamento de funcionários, permitindo operações completas de cadastro, consulta, atualização e desativação de registros e futuramente quero adicionar Spring security para um controle de hierarquia de permissões.

---

## 📌 Funcionalidades

* ✔ Cadastro de funcionários
* ✔ Listagem de funcionários
* ✔ Atualização de dados
* ✔ Desativação de funcionários (soft delete)
* ✔ Validação de CPF único
* ✔ Validação de salário

---

## 🛠️ Tecnologias utilizadas

* Java 17+
* Spring Boot
* Spring Data JPA
* MySQL
* Lombok
* Postman

---

## 🏗️ Arquitetura

O projeto segue o padrão de arquitetura em camadas:

* Controller → Responsável pelas requisições HTTP
* Service → Contém regras de negócio
* Repository → Comunicação com o banco de dados

---

## ⚙️ Como rodar o projeto

### 📌 Pré-requisitos

* Java 17+
* MySQL
* IntelliJ (ou outra IDE)

---

### 🚀 Passo a passo

```bash
# Clone o repositório
git clone https://github.com/leowwesa/gestao-funcionarios.git

# Entre na pasta do projeto
cd sistema-funcionarios
```


### 🗄️ Configuração do banco de dados

1. Crie um banco de dados no MySQL com o nome:

```
funcionarios
```

2. Configure as credenciais no arquivo `application.properties`:

```
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.datasource.url=jdbc:mysql://localhost:3306/funcionarios
```

💡 As tabelas serão criadas automaticamente ao iniciar a aplicação.

---

### ▶️ Executando a aplicação

Você pode rodar o projeto de duas formas:

#### ✔ Via IntelliJ

* Abra o projeto
* Execute a classe `FuncionariosApplication`

#### ✔ Via terminal (Maven)

```bash
./mvnw spring-boot:run
```


```

---

## 🔗 Endpoints principais

### 📍 Criar funcionário

POST /funcionarios

### 📍 Listar funcionários

GET /funcionarios

### 📍 Atualizar funcionário

PUT /funcionarios/{id}

### 📍 Desativar funcionário

DELETE /funcionarios/{id}

---

## 🧠 Regras de negócio implementadas

* CPF não pode ser duplicado
* Salário não pode ser negativo
* Funcionários são desativados ao invés de excluídos

---

## 👨‍💻 Autor

Desenvolvido por Leonardo Araujo

* LinkedIn: https://www.linkedin.com/in/leonardo-araujo-762q
* GitHub: https://github.com/leowwesa
