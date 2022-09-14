CREATE DATABASE agenda; 
USE agenda;

CREATE TABLE contatos(
	
    idcon INT PRIMARY KEY AUTO_INCREMENT, 
    nome VARCHAR(50) NOT NULL, 
    fone VARCHAR(15) NOT NULL, 
    email VARCHAR(50) 
);

SHOW TABLES; 
DESCRIBE contatos;

/* CRUD CREATE */ 

INSERT INTO contatos (nome, fone, email) VALUES('Gustavo', '99999-23923', 'gustavo@gmail.com');

/* CRUD READ */ 
SELECT * FROM contatos;
SELECT * FROM contatos ORDER BY nome;
SELECT * FROM contatos WHERE idcon = 3;

/* CRUD UPDATE */ 
UPDATE contatos set email='doni@gmail.com' WHERE idcon=3;
UPDATE contatos set email='henrique@gmail.com' WHERE idcon=2;
