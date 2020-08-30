create table USUARIOS(
   id INT NOT NULL AUTO_INCREMENT,
   login VARCHAR(100) NOT NULL,
   senha VARCHAR(40) NOT NULL,
   nome_usuario VARCHAR(100) NOT NULL,
   foto MEDIUMBLOB,
   PRIMARY KEY (id),
   UNIQUE (nome_usuario)
);
