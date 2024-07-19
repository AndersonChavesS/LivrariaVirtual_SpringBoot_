package com.example.livrariavirtual.models;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("IMPRESSO")
public class Impresso extends Livro {
    private double frete;
    private int estoque;

    public void atualizarEstoque() {
        this.estoque--;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Impresso " +
                "[frete=" + frete +
                ", estoque=" + estoque +
                '}';
    }
}
