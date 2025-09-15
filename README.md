# 💰 CRUD Controle de Gastos

Projeto de **CRUD (Create, Read, Update, Delete)** para controle de gastos, desenvolvido em **Spring Boot** com **PostgreSQL**.  
Permite o gerenciamento de despesas de forma simples, sendo ideal para aprendizado e prática de desenvolvimento backend.

---

## 📦 Tecnologias usadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **PostgreSQL**
- **Maven**

---

### 💻 Acesse a URL abaixo ou siga o passo a passo para rodar localmente
 ```
https://crud-controle-gastos-kaiquesouza.onrender.com/
```
---

## 🔧 Pré-requisitos

Para rodar o projeto localmente, você precisa ter instalado:

- **[JDK 17+](https://adoptium.net/temurin/releases/)**
- **[Maven](https://maven.apache.org/download.cgi)**
- **[PostgreSQL](https://www.postgresql.org/download/)**

---

## 🗂 Estrutura do projeto
```
CRUD-Controle-Gastos/
├── src/
│ ├── main/
│ │ ├── java/ ← Código-fonte (classes e controllers)
│ │ └── resources/ ← application.properties, templates etc.
│ └── test/ ← Testes unitários
├── Dockerfile ← Configuração para Docker (opcional)
├── pom.xml ← Dependências e configuração do Maven
├── mvnw, mvnw.cmd ← Maven Wrapper
└── .gitignore
```

## ⚙️ Configuração do banco de dados

1. Acesse o PostgreSQL via terminal ou interface gráfica (pgAdmin, TablePlus, etc.).

2. Crie um **banco de dados**:
 ```
CREATE DATABASE controle_gastos;
```
4. Dê permissões ao usuário:
 ```
GRANT ALL PRIVILEGES ON DATABASE controle_gastos TO meu_usuario;
```
--- 
## 🌱 Configuração do projeto
Existem duas formas de configurar a conexão com o banco:

Opção 1 — Usando variáveis de ambiente (recomendado)

Defina estas variáveis no seu sistema ou no Render:

Variável	Exemplo de valor
SPRING_DATASOURCE_URL	jdbc:postgresql://localhost:5432/controle_gastos
SPRING_DATASOURCE_USERNAME	meu_usuario
SPRING_DATASOURCE_PASSWORD	minha_senha
SPRING_PROFILES_ACTIVE	prod (ou dev caso tenha perfis diferentes)

No application.properties deixe assim:
 ```
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```

Opção 2 — Valores diretos (apenas para testes locais)

⚠️ Atenção: Nunca faça deploy em produção com senha exposta.

Edite o arquivo src/main/resources/application.properties:
 ```
spring.datasource.url=jdbc:postgresql://localhost:5432/controle_gastos
spring.datasource.username=meu_usuario
spring.datasource.password=minha_senha
spring.datasource.driver-class-name=org.postgresql.Driver

spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
```
---

## 🚀 Executando o projeto localmente
```
git clone https://github.com/SouzaKaique/CRUD-Controle-Gastos.git
cd CRUD-Controle-Gastos
```
Configure as variáveis de ambiente ou ajuste o application.properties conforme explicado acima.

Execute o projeto:

```
./mvnw spring-boot:run
```

Acesse no navegador:
```
http://localhost:8080
```
--- 
## ☁️ Deploy no Render
Passo a passo:

1. Crie um novo serviço no Render

2. Conecte o repositório GitHub.

3. Em Environment Variables, adicione:

Key	Value (exemplo)
SPRING_DATASOURCE_URL	jdbc:postgresql://<host>/<banco>?sslmode=require
SPRING_DATASOURCE_USERNAME	usuario_do_banco
SPRING_DATASOURCE_PASSWORD	senha_do_banco
SPRING_PROFILES_ACTIVE	prod

4. Salve e faça o deploy.

5. Verifique os logs para garantir que a aplicação subiu corretamente.

## 🛠 Troubleshooting

Erro de autenticação:
```
ERROR: password authentication failed for user '${SPRING_DATASOURCE_USERNAME}'
```
Significa que as variáveis de ambiente não estão sendo lidas.
Verifique se os nomes no Render correspondem exatamente aos usados no application.properties.

Erro de conexão SSL:

Caso veja algo relacionado a SSL, ajuste a URL:
```
jdbc:postgresql://<host>/<banco>?sslmode=require
```

Se o problema persistir, tente remover sslmode=require temporariamente.

## 📜 Licença
Este projeto é de uso livre para fins educacionais e pode ser adaptado conforme necessário.


