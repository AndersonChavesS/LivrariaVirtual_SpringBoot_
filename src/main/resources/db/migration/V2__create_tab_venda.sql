CREATE TABLE venda (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       numero INT,
                       cliente VARCHAR(255),
                       valor DOUBLE
);

CREATE TABLE venda_livro (
                             venda_id BIGINT,
                             livro_id BIGINT,
                             FOREIGN KEY (venda_id) REFERENCES venda(id),
                             FOREIGN KEY (livro_id) REFERENCES livro(id)
);
