CREATE DATABASE IF NOT EXISTS projeto CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE projeto;
CREATE TABLE IF NOT EXISTS usuarios (
 id_usuario INT AUTO_INCREMENT PRIMARY KEY,
 nome VARCHAR(120) NOT NULL,
 usuario VARCHAR(60) NOT NULL UNIQUE,
 email VARCHAR(160) NOT NULL UNIQUE,
 senha VARCHAR(255) NOT NULL,
 salt VARCHAR(64) NOT NULL,
 cpf CHAR(11) NULL UNIQUE
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS workshops (
 codigo INT PRIMARY KEY,
 titulo VARCHAR(140) NOT NULL,
 instrutor VARCHAR(120) NOT NULL,
 data DATE NOT NULL,
 carga VARCHAR(30) NOT NULL,
 vagas INT NOT NULL CHECK (vagas >= 0),
 local VARCHAR(140) NOT NULL
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS fila_espera (
 id_fila INT AUTO_INCREMENT PRIMARY KEY,
 posicao INT NOT NULL,
 aluno VARCHAR(120) NOT NULL,
 evento VARCHAR(140) NOT NULL,
 criado_em TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 UNIQUE KEY uk_fila_aluno_evento (aluno,evento)
) ENGINE=InnoDB;
CREATE TABLE IF NOT EXISTS presencas (
 id_presenca INT AUTO_INCREMENT PRIMARY KEY,
 cpf CHAR(11) NOT NULL,
 codigo_workshop INT NOT NULL,
 data DATE NOT NULL,
 status ENUM('Presente','Ausente','Disponível','Indisponível') NOT NULL,
 CONSTRAINT fk_presenca_workshop FOREIGN KEY (codigo_workshop) REFERENCES workshops(codigo)
 ON UPDATE CASCADE ON DELETE RESTRICT,
 INDEX idx_presenca_cpf (cpf), INDEX idx_presenca_data (data)
) ENGINE=InnoDB;
