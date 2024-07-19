package com.example.livrariavirtual.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_livro")
public abstract class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String titulo;
    private String autores;
    private String editora;
    private double preco;

    @Override
    public String toString() {
        return "Livro{" + "id=" + id +
                ", titulo=" + titulo +
                ", autores=" + autores +
                ", editora=" + editora +
                ", preco=" + preco +
                '}';
    }
}
