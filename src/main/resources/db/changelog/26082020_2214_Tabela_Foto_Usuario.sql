create table USUARIO_FOTOS(
   foto_id INT NOT NULL,
   usuario_id INT NOT NULL,
   PRIMARY KEY (foto_id, usuario_id),
   FOREIGN KEY (foto_id) REFERENCES FOTOS(id),
   FOREIGN KEY (usuario_id) REFERENCES USUARIOS(id)
)