# TODO - CUPOM
### 1. Endpoint create:

* codigo do cupom - String com 6 caracretes, sem caracretes especiais. Caso tenha menos que 6 char, completar

* descricao do cupom

* valor de desconto - Valor minimo de 0.5c

* data de expiracao - LocalDate - nao pode ser contra o dia criado

* isValid = boolean. esse campo define se esta ublicado (liberado par auso) ou false (nao liberado)

2. Endpoint delete
nao ha restricoes para delete, pode ser deletado a qualquer hora
deve ser feito soft delete, ou seja, criar um campo isDeletes = true (cupom ativo) e false = inativo

Obs: h2, testes e github