CREATE TABLE livro (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       titulo VARCHAR(255),
                       autores VARCHAR(255),
                       editora VARCHAR(255),
                       preco DOUBLE,
                       tipo_livro VARCHAR(255) NOT NULL
);

CREATE TABLE impresso (
                          id BIGINT PRIMARY KEY,
                          frete DOUBLE,
                          estoque INT,
                          FOREIGN KEY (id) REFERENCES livro(id)
);

CREATE TABLE eletronico (
                            id BIGINT PRIMARY KEY,
                            tamanho DOUBLE,
                            FOREIGN KEY (id) REFERENCES livro(id)
);
