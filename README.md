# ArqMicroservices
Arquitetura completa com Microservices, Serviços de Mensageria, RabbitMQ, Keycloak, Spring Boot, Spring Data, Spring Security, Spring Cloud, Eureka Server, entre outros.

# Sobre o Projeto

Consiste na criação de um backend de Avaliação de Crédito. Trabalha em conjunto com outros 2 microserviços: msclientes e mscartoes que cadastram os dados do cliente e cadastra cartões de crédito. 

O microserviço msavaliadorcredito, por sua vez, vincula cartões a um cliente baseado na sua renda e idade (regra de negócio interna). Ao emitir um cartão, envia para uma fila e a api devolve um protocolo, bem similar a um ambiente real, quando fazemos um pedido num e-commerce, por exemplo. Esse pedido é recebido pelo microserviço de cartões, que vincula o cartão emitido ao cliente, e isso pode ser consultado e constatado o resultado.

Estou implementando segurança ao ecosistema, com Spring Security e Keycloak e ao final vou dockerizar tudo.

