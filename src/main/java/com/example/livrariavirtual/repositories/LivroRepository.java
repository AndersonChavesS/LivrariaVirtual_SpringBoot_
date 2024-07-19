package com.example.livrariavirtual.repositories;

import com.example.livrariavirtual.models.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LivroRepository extends JpaRepository<Livro, UUID> {
}
