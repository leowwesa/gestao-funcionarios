# 🚀 Sistema de Gerenciamento de Funcionários
API REST desenvolvida em Java utilizando Spring Boot para gerenciamento de funcionários, permitindo operações completas de cadastro, consulta, atualização e desativação de registros com controle de hierarquia de permissões via Spring Security.

---

## 📌 Funcionalidades
* ✔ Cadastro de funcionários
* ✔ Listagem de funcionários
* ✔ Atualização de dados
* ✔ Desativação de funcionários (soft delete)
* ✔ Exclusão permanente de funcionários
* ✔ Validação de CPF único
* ✔ Validação de salário
* ✔ Controle de acesso por perfil (ADMIN, RH, USER)
* ✔ Senhas criptografadas com BCrypt

---

## 🛠️ Tecnologias utilizadas
* Java 17+
* Spring Boot
* Spring Security
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
* DTO → Transferência de dados entre camadas
* Entity → Mapeamento das entidades do banco de dados
* Enum → Definição dos perfis de acesso (ADMIN, RH, USER)
* Config → Configurações de segurança e autenticação
---

## ⚙️ Como rodar o projeto

### 📌 Pré-requisitos
* Java 17+
* MySQL
* IntelliJ

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
💡 Um usuário **ADMIN** padrão será criado automaticamente na primeira execução.

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

---

## 🔐 Autenticação
A API utiliza **HTTP Basic Authentication**. Todas as requisições precisam enviar usuário e senha no header.

### Perfis de acesso
| Role  | Permissões |
|-------|-----------|
| ADMIN | Acesso total |
| RH    | Criar, listar, atualizar e desativar funcionários |
| USER  | Listar funcionários e atualizar o próprio cadastro |

---

## 🔗 Endpoints principais

### 📍 Criar funcionário — `ADMIN` ou `RH`
```
POST /funcionarios
```

### 📍 Listar funcionários — Autenticado
```
GET /funcionarios
```

### 📍 Atualizar funcionário — `ADMIN`, `RH` ou o próprio usuário
```
PUT /funcionarios/{id}
```

### 📍 Desativar funcionário — `ADMIN` ou `RH`
```
DELETE /funcionarios/{id}/desativar
```

### 📍 Excluir funcionário permanentemente — `ADMIN`
```
DELETE /funcionarios/{id}
```

---

## 🧠 Regras de negócio implementadas
* CPF não pode ser duplicado
* Salário não pode ser negativo
* Funcionários são desativados ao invés de excluídos
* Senhas são armazenadas com criptografia BCrypt
* Controle de acesso baseado em roles com Spring Security

---

## 👨‍💻 Autor
Desenvolvido por Leonardo Araujo
* LinkedIn: https://www.linkedin.com/in/leonardo-araujo-762q
* GitHub: https://github.com/leowwesa
