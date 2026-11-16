# Modelo Relacional Normalizado — EventsGym (EVG)

```mermaid
erDiagram
 USUARIOS {
  INT id_usuario PK
  VARCHAR nome
  VARCHAR usuario UK
  VARCHAR email UK
  VARCHAR senha
  CHAR cpf UK
 }
 WORKSHOPS {
  INT codigo PK
  VARCHAR titulo
  VARCHAR instrutor
  DATE data
  VARCHAR carga
  INT vagas
  VARCHAR local
 }
 FILA_ESPERA {
  INT id_fila PK
  INT posicao
  VARCHAR aluno
  VARCHAR evento
  TIMESTAMP criado_em
 }
 PRESENCAS {
  INT id_presenca PK
  CHAR cpf
  INT codigo_workshop FK
  DATE data
  ENUM status
 }
 WORKSHOPS ||--o{ PRESENCAS : possui
```

As tabelas possuem chave primária própria; atributos são atômicos (1FN), os atributos não-chave dependem da chave inteira (2FN) e não há dependências transitivas entre atributos não-chave (3FN). A presença referencia o workshop por chave estrangeira. O CPF pode ser associado a um usuário cadastrado, mas permanece opcional no cadastro da tela original.
