# Instalação e execução — EventsGym

1. Instale JDK 8 ou superior e MySQL 8.
2. Execute `database/projeto.sql` no MySQL Workbench.
3. Adicione o driver **MySQL Connector/J 8.x** ao Build Path do projeto.
4. Configure `EVG_DB_URL` (opcional; padrão `jdbc:mysql://localhost:3306/projeto?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true`), `EVG_DB_USER` (padrão `root`) e `EVG_DB_PASSWORD` (padrão vazio).
5. Importe a pasta `project-main` como projeto Java no Eclipse e execute `telas.TelaLogin`.

O cadastro inicial de usuário é feito pelo botão Cadastrar na tela de login. A autenticação consulta a tabela `usuarios`. As senhas novas são armazenadas com PBKDF2-HMAC-SHA256 e salt aleatório.

**Observação de validação:** o código-fonte foi compilado com compatibilidade Java 8. O ambiente usado para preparar o arquivo não possui servidor MySQL nem MySQL Connector/J instalado; portanto, a conexão real, a execução do script SQL e o fluxo ponta a ponta devem ser validados no computador de execução seguindo `database/testes-manuais.md`.
