<div align="center" style="margin-top:20px; margin-bottom:20px;">

## Refood - Back-End

<img src="./logo.png" width="120px" /><br />

</div>

## Índice

- [Sobre](#sobre)
- [Integrantes](#integrantes)
- [Tecnologias utilizadas](#tecnologias-utilizadas)
- [Pré Requisitos](#pre-requisitos)
- [Configuração](#config)
- [Executando o projeto](#exe)
- [API Endpoints](#endpoints)

<div id="sobre">

## 📄Sobre

**Refood** é uma plataforma onde estabelecimentos comerciais podem vender produtos próximos da data de validade a preços mais acessíveis, permitindo que consumidores adquiram esses itens e contribuam para a redução do desperdício de alimentos.

### Principais Características:

1. **Gestão de Restaurantes**: Permite o cadastro e gerenciamento completo de restaurantes, incluindo informações básicas, horários de funcionamento e cardápios.
2. **Sistema de Pedidos**: Oferece um robusto sistema de criação, acompanhamento e gerenciamento de pedidos, facilitando o processo tanto para clientes quanto para restaurantes.
3. **Autenticação e Segurança**: Implementa um sistema seguro de autenticação de usuários com JWT e OAuth2, garantindo a proteção dos dados dos clientes e restaurantes.
4. **Gestão de Produtos**: Possibilita o cadastro detalhado de produtos, com suporte a categorias, variações e upload de imagens.
5. **Endereços e Entregas**: Gerencia endereços de entrega dos clientes, com validação e busca por CEP.
6. **Avaliações e Feedback**: Permite que os clientes avaliem os restaurantes e os pedidos, fornecendo feedback valioso para melhoria contínua.
7. **Integração com Firebase**: Utiliza o Firebase para armazenamento eficiente de imagens e outros arquivos.
8. **Documentação Interativa**: Oferece uma documentação completa da API através do Swagger, facilitando a integração e o desenvolvimento.

</div>

<div id="integrantes">

## 👨‍💻Integrantes

| [<img loading="lazy" src="https://avatars.githubusercontent.com/u/115363966?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Caio Martins](https://github.com/CaioMMendes) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/93887208?s=96&v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Felipe Fracasso](https://github.com/FelipeM-F) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/150201828?s=96&v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Leonardo Boeira](https://github.com/leomaciel14) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/131506431?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Marina Barbosa](https://github.com/marina-barbosa) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/89655285?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Ricardo Muenchen](https://github.com/RicardoDM23) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/63266170?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Samilis Brito](https://github.com/SamilisBrito) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/102476639?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Thasyo Peres](https://github.com/Thasyo) | [<img loading="lazy" src="https://avatars.githubusercontent.com/u/102565778?v=4" width=80 style='display:flex; justify-content:center; align-items:center; text-decoration:none;' ><br>Yasmin Carlôto](https://github.com/Yasmin-Carloto) |
| --- | --- | --- | --- | --- | --- | --- | --- |

</div>

<div id="tecnologias-utilizadas">

## 🚀 Tecnologias

- Java 17
- Spring Boot 3.3.4
- Spring Security com OAuth2
- Spring Data JPA
- PostgreSQL
- H2 Database (desenvolvimento)
- Swagger/OpenAPI
- JWT Authentication
- Firebase Integration
- Maven
- Lombok
- HATEOAS

</div>

<div id="pre-requisitos">

## 🛠️ Pré-requisitos

- JDK 17
- Maven
- PostgreSQL
- Firebase Account (para storage)

</div>

<div id="config">

## ⚙️ Configuração

1. Clone o repositório

```shellscript
git clone https://github.com/seu-usuario/refoods-api.git
cd refoods-api
```


2. Configure o banco de dados

```plaintext
# src/main/resources/application.properties
spring.datasource.url=jdbc:postgresql://localhost:5432/refoods
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```


3. Configure o Firebase

    - Adicione o arquivo de configuração do Firebase (`firebase-config.json`) ao diretório `src/main/resources`


4. Configure as variáveis de ambiente

```plaintext
JWT_SECRET=seu_jwt_secret
FIREBASE_CONFIG_PATH=caminho_para_config_firebase
```

</div>

<div id="exe">

## 🖥️ Executando o Projeto

1. Build do projeto

```shellscript
mvn clean install
```


2. Execute a aplicação

```shellscript
mvn spring-boot:run
```


3. Acesse a documentação Swagger

```plaintext
http://localhost:8080/swagger-ui.html
```

</div>

<div id="endpoints">

## 📚 API Endpoints

A documentação completa da API está disponível através do Swagger UI quando o projeto está em execução.


## Controlador de Usuário

`GET /api/user` - Obter todos os usuários

`GET /api/user/{id}` - Obter usuário por ID

`POST /api/user` - Criar um novo usuário

`PUT /api/user/{id}` - Atualizar usuário

`DELETE /api/user/{id}` - Excluir usuário

`GET /api/user/profile` - Obter perfil do usuário

`PUT /api/user/profile` - Atualizar perfil do usuário

## Controlador de Restaurante

`GET /api/restaurant` - Obter todos os restaurantes

`POST /api/restaurant` - Criar um novo restaurante

`GET /api/restaurant/{id}` - Obter restaurante por ID

`PUT /api/restaurant/{id}` - Atualizar restaurante

`DELETE /api/restaurant/{id}` - Excluir restaurante

`GET /api/restaurant/search` - Pesquisar restaurantes

`GET /api/restaurant/{id}/menu` - Obter cardápio do restaurante

`POST /api/restaurant/{id}/product` - Adicionar produto ao restaurante

`GET /api/restaurant/{restaurantId}/product/{productId}` - Obter produto específico do restaurante

`PUT /api/restaurant/{restaurantId}/product/{productId}` - Atualizar produto no restaurante

`DELETE /api/restaurant/{restaurantId}/product/{productId}` - Remover produto do restaurante

## Controlador de Horários do Restaurante

`GET /api/restaurant/{restaurantId}/hours` - Obter horários do restaurante

`POST /api/restaurant/{restaurantId}/hours` - Definir horários do restaurante

`PUT /api/restaurant/{restaurantId}/hours/{hoursId}` - Atualizar horários do restaurante

`DELETE /api/restaurant/{restaurantId}/hours/{hoursId}` - Excluir horários do restaurante

`GET /api/restaurant/{restaurantId}/hours/{dayOfWeek}` - Obter horários do restaurante para um dia específico

`PUT /api/restaurant/{restaurantId}/hours/{dayOfWeek}` - Atualizar horários do restaurante para um dia específico

## Controlador de Cartão

`GET /api/card` - Obter todos os cartões

`POST /api/card` - Criar um novo cartão

`GET /api/card/{id}` - Obter cartão por ID

`PUT /api/card/{id}` - Atualizar cartão

`DELETE /api/card/{id}` - Excluir cartão

`GET /api/card/user/{userId}` - Obter cartões por ID do usuário

## Controlador de Endereço

`GET /api/address` - Obter todos os endereços

`POST /api/address` - Criar um novo endereço

`GET /api/address/{id}` - Obter endereço por ID

`PUT /api/address/{id}` - Atualizar endereço

`DELETE /api/address/{id}` - Excluir endereço

`GET /api/address/user/{userId}` - Obter endereços por ID do usuário

`POST /api/address/validate` - Validar endereço

`GET /api/address/search` - Pesquisar endereços por CEP

## Controlador de Autenticação

`POST /api/auth/login` - Login do usuário

`POST /api/auth/register` - Registro de usuário

`POST /api/auth/logout` - Logout do usuário

`POST /api/auth/refresh-token` - Atualizar token de autenticação

## Controlador de Transação

`GET /api/transaction` - Obter todas as transações

`POST /api/transaction` - Criar uma nova transação

`GET /api/transaction/{id}` - Obter transação por ID

## Controlador de Avaliação

`GET /api/review` - Obter todas as avaliações

`POST /api/review` - Criar uma nova avaliação

`GET /api/review/{id}` - Obter avaliação por ID

`PUT /api/review/{id}` - Atualizar avaliação

`DELETE /api/review/{id}` - Excluir avaliação

`GET /api/review/restaurant/{restaurantId}` - Obter avaliações para um restaurante específico

## Controlador de Produto

`GET /api/product` - Obter todos os produtos

`POST /api/product` - Criar um novo produto

`GET /api/product/{id}` - Obter produto por ID

`PUT /api/product/{id}` - Atualizar produto

`DELETE /api/product/{id}` - Excluir produto

`GET /api/product/search` - Pesquisar produtos

`GET /api/product/category/{categoryId}` - Obter produtos por categoria

`POST /api/product/{id}/image` - Fazer upload de imagem do produto

`DELETE /api/product/{id}/image` - Excluir imagem do produto

## Controlador de Pedido

`GET /api/order` - Obter todos os pedidos

`POST /api/order` - Criar um novo pedido

`GET /api/order/{id}` - Obter pedido por ID

`PUT /api/order/{id}` - Atualizar pedido

`DELETE /api/order/{id}` - Excluir pedido

`GET /api/order/user/{userId}` - Obter pedidos por ID do usuário

`GET /api/order/restaurant/{restaurantId}` - Obter pedidos para um restaurante

`PUT /api/order/{id}/status` - Atualizar status do pedido

`POST /api/order/{id}/payment` - Processar pagamento do pedido

## Controlador do Firebase

`POST /api/firebase/upload` - Fazer upload de arquivo para o Firebase Storage

`GET /api/firebase/image/{imageName}` - Obter imagem do Firebase Storage

## Controlador de Favoritos

`GET /api/favorite` - Obter todos os favoritos

`POST /api/favorite` - Adicionar um favorito

`DELETE /api/favorite/{id}` - Remover um favorito

`GET /api/favorite/user/{userId}` - Obter favoritos de um usuário

## Controlador de Carrinho

`GET /api/cart` - Obter carrinho

`POST /api/cart` - Adicionar item ao carrinho

`PUT /api/cart/{itemId}` - Atualizar item do carrinho

`DELETE /api/cart/{itemId}` - Remover item do carrinho

`DELETE /api/cart` - Limpar carrinho

## Controlador de Token

`GET /api/token/info` - Obter informações do token

</div>


## Estrutura de pastas

```plaintext
src/
├── main/
│   ├── java/
│   │   └── com.projeto.ReFood/
│   │       ├── controller/
│   │       ├── dto/
│   │       ├── exception/
│   │       ├── firebase/
│   │       ├── model/
│   │       ├── repository/
│   │       ├── security/
│   │       ├── service/
│   │       ├── swagger/
│   │       └── ReFoodsApplication.java
│   └── resources/
│       └── ...
└──...
```

# Descrição das pastas

src/main/java/com.projeto.ReFood/: Contém o código-fonte Java principal do projeto.

- controller/: Onde ficam os controllers, responsáveis por lidar com as requisições HTTP e definir os endpoints da API. Os controllers traduzem as requisições dos usuários em chamadas para os serviços da aplicação.

- dto/: Armazena as classes DTO (Data Transfer Object). Essas classes são usadas para transportar dados entre as camadas da aplicação e podem ser usadas para mapear objetos de entrada e saída da API.

- exception/: Contém as classes relacionadas ao tratamento de exceções. Aqui você pode criar exceções personalizadas e lidar com erros globais, como respostas personalizadas para códigos de erro HTTP.

- model/: Armazena as classes que representam os modelos de dados (entidades). Essas classes geralmente são mapeadas para tabelas de banco de dados e são usadas para persistência de dados com o JPA (Java Persistence API).

- repository/: Contém as interfaces repository, que se comunicam diretamente com o banco de dados. Usando JPA, você pode definir métodos para realizar operações como salvar, atualizar, excluir ou consultar entidades no banco de dados.

- security/: Contém as configurações e classes relacionadas à segurança da aplicação, como autenticação e autorização, usando OAuth2, JWT e outras estratégias de segurança.

- service/: Contém as classes de service, responsáveis pela lógica de negócios. Essa camada realiza o processamento de dados e coordena as operações entre os repositórios e os controllers.

- ReFoodsApplication.java: Classe principal da aplicação Spring Boot, contendo o método main. Esta é a classe que inicializa e configura o contexto da aplicação.

- src/main/resources/: Armazena recursos não Java, como arquivos de configuração (application.properties ou application.yml), templates de e-mail, arquivos de mapeamento SQL e outros recursos que a aplicação pode precisar.


## 📄 Licença

Este projeto está sob a licença MIT - veja o arquivo [LICENSE.md](LICENSE.md) para detalhes.

## 👏 Agradecimentos

- [Spring Boot](https://spring.io/projects/spring-boot)
- [PostgreSQL](https://www.postgresql.org/)
- [Firebase](https://firebase.google.com/)
- Todos os contribuidores e apoiadores do projeto ReFoods


---

Desenvolvido com ☕ e 💚 pela equipe ReFoods