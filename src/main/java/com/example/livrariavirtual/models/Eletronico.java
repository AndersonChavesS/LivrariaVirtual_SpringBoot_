package com.example.livrariavirtual.models;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@DiscriminatorValue("ELETRONICO")
public class Eletronico extends Livro {
    private double tamanho;

    @Override
    public String toString() {
        return super.toString() + "Eletronico{" +
                "\nTamanho: " + tamanho +
                '}';
    }
}
