create table COMENTARIOS_FOTO(
   id INT NOT NULL,
   foto_id INT NOT NULL,
   usuario_id INT NOT NULL,
   comentario VARCHAR(2000) NOT NULL,
   curtidas INT,
   PRIMARY KEY (id),
   FOREIGN KEY (foto_id) REFERENCES FOTOS(id),
   FOREIGN KEY (usuario_id) REFERENCES USUARIOS(id)
)