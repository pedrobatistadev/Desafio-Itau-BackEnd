# Desafio Itaú Unibanco

API REST desenvolvida em **Java 21** e **Spring Boot** para o Desafio de Programação do Itaú Unibanco.

A aplicação recebe transações, armazena os dados em memória e disponibiliza estatísticas referentes às transações realizadas nos últimos 60 segundos(Configurável).

## Tecnologias

* Java 21
* Spring Boot
* Maven
* Bean Validation
* Swagger / OpenAPI

---

# Endpoints

## POST `/transacao`

Registra uma nova transação.

### Request

```json
{
    "valor": 123.45,
    "dataHora": "2020-08-07T12:34:56.789-03:00"
}
```

### Campos

| Campo      | Tipo             | Obrigatório |
| ---------- | ---------------- | ----------- |
| `valor`    | `Double`         | Sim         |
| `dataHora` | `OffsetDateTime` | Sim         |

### Regras

* `valor` deve ser maior ou igual a `0`;
* `dataHora` não pode estar no futuro;
* `valor` e `dataHora` são obrigatórios;
* `dataHora` deve seguir o padrão ISO 8601.

### Respostas

| HTTP Status                | Descrição                        |
| -------------------------- | -------------------------------- |
| `201 Created`              | Transação registrada com sucesso |
| `422 Unprocessable Entity` | Transação inválida               |
| `400 Bad Request`          | Requisição inválida              |

As respostas não possuem corpo.

---

## DELETE `/transacao`

Remove todas as transações armazenadas.

### Resposta

```text
200 OK
```

A resposta não possui corpo.

---

## GET `/estatistica`

Retorna as estatísticas das transações realizadas nos últimos 60 segundos.

### Response

```json
{
    "count": 10,
    "sum": 1234.56,
    "avg": 123.456,
    "min": 12.34,
    "max": 123.56
}
```

### Campos

| Campo   | Tipo     | Descrição                |
| ------- | -------- | ------------------------ |
| `count` | `long`   | Quantidade de transações |
| `sum`   | `Double` | Soma dos valores         |
| `avg`   | `Double` | Média dos valores        |
| `min`   | `Double` | Menor valor              |
| `max`   | `Double` | Maior valor              |

Quando não houver transações nos últimos 60 segundos:

```json
{
    "count": 0,
    "sum": 0,
    "avg": 0,
    "min": 0,
    "max": 0
}
```

# Validações

As transações são validadas antes de serem armazenadas.

São rejeitadas transações que:

* não possuam `valor`;
* não possuam `dataHora`;
* possuam valor negativo;
* possuam data/hora futura;
* possuam dados em formato inválido.

---

# Armazenamento

Os dados são armazenados exclusivamente em memória, conforme especificado no desafio.

Não são utilizados bancos de dados ou sistemas de cache.

Os dados são perdidos quando a aplicação é encerrada.

---

# Swagger

A documentação da API está disponível através do Swagger UI:

```text
http://localhost:8080/swagger
```

---

# Estrutura do projeto

```text
src/
├── main/
│   └── java/
│       └── com/desafio/itau/
│           ├── controller/
│           ├── model/
│           ├── service/
│           └── ...
│
└── test/
    └── java/
        └── com/desafio/itau/
```

---

# Requisitos do desafio

| Requisito                             | Implementado |
| ------------------------------------- | ------------ |
| API REST                              | ✅            |
| Java / Spring Boot                    | ✅            |
| Armazenamento em memória              | ✅            |
| `POST /transacao`                     | ✅            |
| `DELETE /transacao`                   | ✅            |
| `GET /estatistica`                    | ✅            |
| Validação das transações              | ✅            |
| Estatísticas dos últimos 60 segundos  | ✅            |
| Tratamento dos status HTTP            | ✅            |
| Documentação Swagger                  | ✅            |
| Período das estatísticas configurável | ✅            |

---

# Autor

**Pedro Lucas Alves Batista**

Desafio de Programação — Itaú Unibanco
