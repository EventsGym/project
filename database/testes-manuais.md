# Roteiro de validação funcional

> A compilação Java foi validada. Os testes de integração abaixo precisam ser executados em uma instalação MySQL real com o Connector/J, pois o ambiente de montagem não possui servidor MySQL.

1. Criar o banco executando `projeto.sql`.
2. Adicionar MySQL Connector/J ao Build Path e configurar usuário/senha.
3. Abrir `telas.TelaLogin` e cadastrar um usuário; verificar o registro em `usuarios` (senha armazenada como hash e salt, não texto puro).
4. Sair e autenticar com o usuário cadastrado; testar senha incorreta.
5. Na tela de workshops, cadastrar, selecionar e alterar, excluir um workshop sem presenças e confirmar que um workshop referenciado por presença não pode ser excluído (integridade referencial).
6. Na tela de fila, incluir um aluno/evento e reiniciar a aplicação para verificar persistência e prevenção de duplicidade.
7. Na tela de presença, selecionar um workshop, informar CPF e registrar presença; confirmar o registro na tabela `presencas`.
8. Na tela de vagas, atualizar e confirmar que inscritos/disponíveis refletem os registros persistidos.
9. Na consulta de histórico, filtrar por CPF, evento e data e conferir os registros.

## Critério de aceite

Cada operação deve exibir mensagem de sucesso somente depois da confirmação do banco. Em caso de falha de conexão, restrição ou validação, a tela deve informar o erro e manter a operação sem simular persistência.
