# 🚀 Link Shortener Application

## Descrição
Uma aplicação simples para encurtar URLs, desenvolvida usando o framework Spring Boot.
Permite gerar links encurtados e redirecioná-los para a URL original.

## 📦️ Estrutura do Projeto
O projeto segue a seguinte organização de pacotes:
- **Controller**: Responsável pelos endpoints REST e interação com o cliente.
- **Model**: Contém as classes de modelo e entidades do banco de dados.
- **Repository**: Interfaces para acesso ao banco de dados, baseadas no Spring Data JPA.
- **Service**: Implementa a lógica de negócio.

## Configuração

### 🗃️ Banco de Dados
A aplicação usa o banco de dados em memória H2. As configurações estão no arquivo `application.properties`:

```properties
spring.application.name=shortener
spring.h2.console.enabled=true
spring.h2.console.path=/h2
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
spring.datasource.driver-class-name=org.h2.Driver
```

Para acessar o console do H2, visite [http://localhost:8080/h2-console](http://localhost:8080/h2-console).

### ⚗️ Dependências Principais
- **Spring Boot Starter Web**: Para criar a API REST.
- **Spring Boot Starter Data JPA**: Para persistência de dados.
- **H2 Database**: Banco de dados em memória.
- **Spring Boot DevTools**: Para agilizar o desenvolvimento com recarregamento automático.
- **Apache Commons Lang 3**: Utilitários para operações com strings.
- **Google Guava**: Biblioteca de utilidades do Java.

## Requisitos
- **Java**: 22.0.1 ou superior
- **Maven**: 3.8.1 ou superior

## Como Rodar a Aplicação
1. Clone o repositório.
2. Navegue até o diretório do projeto.
3. Execute o comando abaixo para iniciar a aplicação:
   ```bash
   mvn spring-boot:run
   ```

A aplicação será executada em [http://localhost:8080](http://localhost:8080).

## 🌐 Endpoints

### Gerar URL Encurtada
**POST** `/generate`

**Request Body:**
```json
{
    "url": "https://www.youtube.com/watch?v=CihfMVePlcQ&ab_channel=CachedInsights"
}
```

**Response:**
```json
{
    "shortUrl": "http://localhost:8080/a4f07dbe"
}
```

### Redirecionar para URL Original
**GET** `/{shortUrl}`

Exemplo:
```
GET http://localhost:8080/a4f07dbe
```
Redireciona para: `https://www.youtube.com/watch?v=CihfMVePlcQ&ab_channel=CachedInsights`.

## Testes
Para executar os testes:
```bash
mvn test
```

## 🧑‍💻 Contribuições
Sinta-se livre para sugerir ou melhorar o código, aceito sugestões e aprendo a lidar com os erros. 

