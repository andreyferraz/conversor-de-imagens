# Conversor de Imagens

Este projeto é uma aplicação web criada para converter imagens de qualquer formato para o formato WebP. Desenvolvido com Java, Spring Boot e Thymeleaf, o conversor é capaz de lidar com upload de imagens e convertê-las para o formato WebP usando as bibliotecas apropriadas.

## Tecnologias

- **Java** 17
- **Spring Boot** 3.3.3
- **Thymeleaf** para renderização de páginas HTML
- **Sejda ImageIO** para suporte ao formato WebP
- **SpringDoc OpenAPI** para documentação da API
- **JUnit** e **Mockito** para testes

## Dependências

O projeto utiliza as seguintes dependências:

- `spring-boot-starter-actuator`
- `spring-boot-starter-thymeleaf`
- `spring-boot-starter-web`
- `spring-boot-devtools` (para desenvolvimento)
- `spring-boot-starter-test` (para testes)
- `h2` (banco de dados em memória)
- `springdoc-openapi-starter-webmvc-ui` (para documentação da API)
- `org.sejda.imageio:webp-imageio:0.1.6`
- `org.mockito:mockito-core:5.0.0` (para testes)
- `org.junit.jupiter:junit-jupiter-api:5.9.3` e `org.junit.jupiter:junit-jupiter-engine:5.9.3` (para testes)

## Funcionalidades

- **Conversão de Imagens**: Permite o upload de uma imagem e a conversão para o formato WebP através de um endpoint REST.
- **Interface Web**: Página HTML com Thymeleaf para permitir que os usuários façam upload de imagens e recebam a imagem convertida como um arquivo de download.
- **Documentação da API**: Documentação interativa da API disponível através do SpringDoc OpenAPI.

### Conversão de Imagem

- **URL**: `/api/image/convert`
- **Método**: POST
- **Parâmetro**: `file` (arquivo de imagem para conversão)
- **Resposta**: Imagem convertida no formato WebP com o nome do arquivo original.

### Página de Conversão

- **URL**: `/converter`
- **Método**: GET
- **Descrição**: Página para upload de imagens e conversão para o formato WebP.

## Como Executar

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/seu-usuario/conversor-de-imagens.git

2. **Navegue até o diretório do projeto**:
    ```bash
    cd conversor-de-imagens

3. **Navegue até o diretório do projeto**:
    ```bash
    ./mvn spring-boot:run

3. **Acesse a aplicação**:
- Acesse a página de conversão em http://localhost:8080/converter
- Envie uma imagem para o endpoint /api/image/convert para obter a versão WebP da imagem.