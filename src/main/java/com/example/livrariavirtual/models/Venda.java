package com.example.livrariavirtual.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Entity
@Table(name = "venda")
public class Venda {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private static int numVendas = 0;
    private int numero;
    private String cliente;
    private double valor;

    @ManyToMany
    @JoinTable(
            name = "venda",
            joinColumns = @JoinColumn(name = "venda_id"),
            inverseJoinColumns = @JoinColumn(name = "livro_id")
    )
    private List<Livro> livros;

    public Venda() {
        this.numero = ++numVendas;
    }

    public void addLivro(Livro livro) {
        this.livros.add(livro);
    }

    public void listarLivro() {
        for (Livro livro : livros) {
            System.out.println(livro);
        }
    }
}
