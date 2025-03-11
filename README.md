# SiGProtocolos
Sistema de Gestão de Protocolos

## Como Rodar:
  Com o Docker instaladado rode `docker-compose up --build` na raiz do projeto e acesse o link `http://localhost:8081/cadastrar-protocolos`.
## Usando apenas a API:
  * Para cadastrar um protocoloco faça um requisição `POST` para `http://localhost:8081/protocolos`.   
    * O json precisa passar apenas o o tipo da natureza com um valor de 0 a 2. ex: `{"natureza":"0"}`.
  * Para listar todos os protocolos faça um requisição `GET` para `http://localhost:8081/protocolos`.  


## Outras informações:  
    Java: 17  
    Backend:SpringBoot    
    Frontend:Vaadin  
    Banco: PostgreSQL  
