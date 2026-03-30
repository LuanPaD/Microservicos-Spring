# 🛒 Microservicos Spring | Loja Virtual (BFF + APIs)

Este projeto simula o backend de uma loja virtual com 3 servicos Java Spring Boot conectados.
Cada servico cuida de um contexto especifico, e o BFF (Backend for Frontend) centraliza as chamadas para entregar um ponto unico de acesso para o cliente.

## 🧩 Arquitetura

1. **loja-virtual-bff** (porta `8383`) recebe as chamadas do cliente.
2. O BFF consome:
   - **cadastro-usuario** (porta `8282`) para criar, buscar e excluir usuarios.
   - **api_pagamentos** (porta `8484`) para validar pagamento.
   - **API de produtos externa/local** em `8181` (consumo via Feign).

## 📦 Repositorios do workspace

- `loja-virtual-bff`: camada de orquestracao e endpoints de fachada.
- `cadastro-usuario`: CRUD de usuario com Spring Data JPA + PostgreSQL.
- `api_pagamentos`: mock de aprovacao de cartao (regra simples de validacao).

## 🛠️ Tecnologias

<p>
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" alt="Java" width="42" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" alt="Spring Boot" width="42" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" alt="PostgreSQL" width="42" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/swagger/swagger-original.svg" alt="Swagger" width="42" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/gradle/gradle-original.svg" alt="Gradle" width="42" />
</p>

![OpenFeign](https://img.shields.io/badge/OpenFeign-Spring%20Cloud-2E7D32?style=flat-square)
![Spring Data JPA](https://img.shields.io/badge/Spring%20Data-JPA-2E7D32?style=flat-square)
![Lombok](https://img.shields.io/badge/Lombok-Java-CA1F1F?style=flat-square)

## 🔌 Endpoints principais

### BFF (`http://localhost:8383/loja-virtual`)

- `GET /produtos`
- `GET /produtos/{nome}`
- `POST /usuario`
- `DELETE /usuario/{email}`
- `POST /compra`

### Usuario (`http://localhost:8282/user`)

- `POST /user`
- `GET /user?email=...`
- `DELETE /user?email=...`

### Pagamento (`http://localhost:8484/pagamento`)

- `POST /pagamento`

## 🧪 Fluxo rapido para demonstracao

### Criar usuario pelo BFF

```bash
curl -X POST http://localhost:8383/loja-virtual/usuario \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Ana Lima",
    "email": "ana@email.com",
    "documento": "12345678900",
    "endereco": {
      "rua": "Rua A",
      "numero": "100",
      "bairro": "Centro",
      "complemento": "Apto 11",
      "cidade": "Sao Paulo",
      "cep": "01001000"
    }
  }'
```

### Simular compra pelo BFF

```bash
curl -X POST http://localhost:8383/loja-virtual/compra \
  -H "Content-Type: application/json" \
  -d '{
    "produto": "nome-do-produto",
    "email": "ana@email.com",
    "numeroCartao": "1234567898080",
    "mes": "12",
    "ano": "2030",
    "cvv": "123"
  }'
```

> Regra atual da API de pagamento: cartoes terminados em `8080` retornam aprovacao.

## 📘 Swagger

- UI: `http://localhost:8383/swagger-ui/index.html`
