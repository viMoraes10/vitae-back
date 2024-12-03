# Vitae

Aplicativo *Vitae*, Plataforma de Denúncia e Apoio a Violações de Direitos Humanos em desenvolvimento por alunos do sexto semestre de Engenharia da Computação.

## 🚀 Começando

Essas instruções permitirão que você obtenha uma cópia do projeto em operação na sua máquina local para fins de desenvolvimento e teste.

## Configuração do Ambiente

### Backend (Java)

# Clone o repositório
git clone https://github.com/viMoraes10/vitae-back.git

# Navegue até o diretório do projeto
cd vitae-back

# Instale as dependências:

# Para sistemas Unix/Linux
./mvnw spring-boot:run

# Para Windows
mvnw.cmd spring-boot:run
## Configuração do Banco de Dados

Instale o PostgreSQL e tenha o banco de dados em execução. Caso não tenha o PostgreSQL instalado, você pode baixá-lo no site oficial.

Crie um banco de dados para o projeto:
CREATE DATABASE vitae_db;

### Configuração do application.properties:
Navegue até src/main/resources/application.properties e ajuste as informações de banco de dados:
spring.datasource.url=jdbc:postgresql://localhost:5432/vitae_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

## Backend (Spring Boot)

### Configuração

Certifique-se de instalar as dependências:

bash
# Clone o repositório
git clone https://github.com/seu-usuario/vitae-backend.git

# Navegue até o diretório do projeto
cd vitae-backend


### Configurando o Banco de Dados

1. Certifique-se de que o PostgreSQL está instalado e em execução em sua máquina.

   2. Crie um banco de dados para o projeto:

      sql
      CREATE DATABASE vitae_db;


3. Configure o arquivo application.properties localizado em src/main/resources/ com as informações do seu banco de dados:

   properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/vitae_db
   spring.datasource.username=seu_usuario
   spring.datasource.password=sua_senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
   spring.jpa.properties.hibernate.format_sql=true


### Executando o Servidor

Na raiz do projeto, execute:

bash
# Para sistemas Unix/Linux
./mvnw spring-boot:run

# Para Windows
mvnw.cmd spring-boot:run


O servidor iniciará na porta 8080.

## 📋 Pré-requisitos

Antes de começar, certifique-se de ter instalado em seu ambiente de desenvolvimento:

  - *Java JDK*: Versão 8 ou superior. [Download Java JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

  - *Maven*: Para gerenciar dependências e build do projeto (https://maven.apache.org/download.cgi)

  - *Git*: Para controle de versão. [Download Git](https://git-scm.com/downloads)

  - *PostgreSQL*: Para o banco de dados. [Download PostgreSQL](https://www.postgresql.org/download/)

## ⚙ Executando os testes

### 🔩 Testes de Backend

Para executar os testes automatizados do backend:

1. Na raiz do projeto backend, execute:

   bash
   ### Para sistemas Unix/Linux
   ./mvnw test

   ### Para Windows
   mvnw.cmd test

2. Os testes unitários e de integração serão executados usando *JUnit* e *Mockito*.


## 📦 Implantação

### Backend

- *Docker*: Você pode criar uma imagem Docker do backend para implantação. Certifique-se de ter o Docker instalado e execute:

  bash
  docker build -t vitae-backend .
  docker run -p 8080:8080 vitae-back

## Criar a imagem Docker:
Criar a imagem Docker:
No diretório raiz do projeto, execute:
docker build -t vitae-backend .

Rodar o container:

Após criar a imagem Docker, inicie o container com o comando:
docker run -p 8080:8080 vitae-backend

O backend estará acessível em http://localhost:8080.




## 🛠 Construído com

### Metodologias e Práticas

- *Git*: Controle de versão distribuído para gerenciamento do código-fonte.
  - *Scrum*: Gestão e planejamento do projeto em sprints.
  - *Kanban*: Otimização dos fluxos de trabalho.
  - *Programação em Par (Pair Programming)*: Melhoria da qualidade do código e disseminação do conhecimento.
  - *Integração Contínua (CI) e Entrega Contínua (CD)*: Automação das fases de teste e entrega.

### Desenvolvimento do Frontend

- *React Native*: Desenvolvimento de aplicativos móveis nativos para Android e iOS.
  - *Visual Studio Code*: Ambiente de desenvolvimento integrado (IDE).
  - *JavaScript (ES6+)*: Linguagem de programação utilizada.
  - *React Navigation*: Gerenciamento de navegação entre telas.
  - *Styled Components*: Estilização dos componentes de interface.
  - *Redux*: Gerenciamento do estado global da aplicação.
  - *Axios*: Chamadas HTTP para comunicação com a API backend.
  - *Jest*: Framework de testes unitários.
  - *Fastlane*: Automação do processo de build e deploy do aplicativo.

### Desenvolvimento do Backend

- *Java*: Linguagem de programação base para o backend.
  - *Spring Boot*: Framework para construção de aplicações Java.
  - *PostgreSQL*: Sistema de gerenciamento de banco de dados relacional.
  - *RESTful API com Spring Boot*: Comunicação entre o backend e os clientes.
  - *Spring Security*: Autenticação e autorização.
  - *Postman*: Testes e documentação das APIs.
  - *JUnit e Mockito*: Frameworks de testes.
  - *Docker*: Criação de containers para facilitar o deploy.

## ✒ Autores

* *Maicon Douglas Mendes Alves* - Desenvolvimento - [MaiconDouglasAlves](https://github.com/linkParaPerfil)
  * *Carlos Alberto de Aguiar* - Desenvolvimento - [CarlosAguiar](https://github.com/linkParaPerfil)
  * *João Marcos Racanelli* - Desenvolvimento - [JoaoRacanelli](https://github.com/linkParaPerfil)
  * *Leonardo Marcondeli* - Desenvolvimento - [LeonardoMarcondeli](https://github.com/linkParaPerfil)
  * *Vinicius de Moraes de Godoi* - Desenvolvimento - [ViniciusGodoi](https://github.com/linkParaPerfil)

## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](https://github.com/usuario/vitae/blob/main/LICENSE.md) para detalhes.

## 🎓 Agradecimentos

Projeto desenvolvido como parte do curso de Engenharia de Computação - 6° semestre da UNISAL - Centro Universitário Salesiano de São Paulo, sob orientação do Prof. M.Sc. Paulo César Barreto da Silva.

---

© 2024 Vitae - Plataforma de Denúncia e Apoio a Violações de Direitos Humanos