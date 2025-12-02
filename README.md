# Gerador de Cupons

API REST para criar e deletar cupons.

## Tecnologias
- Java 17+
- Spring Boot
- Maven

## Endpoints

| Método | URL | Descrição |
|--------|-----|-----------|
| POST   | /api/v1/cupom/create | Cria um cupom |
| DELETE | /api/v1/cupom/delete/{id} | Deleta um cupom ativo pelo ID |

### POST /api/v1/cupom/create
**Body JSON:**
```json
{
  "code": "XXX000",
  "discountValue": 1,
  "expirationDate": "2025-12-31",
  "published": true,
  "description": "Test discount"
}
```

### DELETE /api/v1/cupom/delete/{id}
**Insira o ID do banco de dados**

## Como rodar

1. Clone o projeto:
```bash
git clone https://github.com/matheusdpo/desafio-tecnico-gerador-cupom.git
cd desafio-tecnico-gerador-cupom
```
2. Rode a aplicação:
```bash
mvn clean spring-boot:run
```
3. Acesse o banco em em `http://localhost:9000/h2-console`
- Login: gerador
- Senha: gerador
