package com.example.livrariavirtual.services;

import com.example.livrariavirtual.models.Livro;
import com.example.livrariavirtual.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LivroService {
    @Autowired
    private LivroRepository livroRepository;

    public Livro save(Livro livro) {
        return livroRepository.save(livro);
    }

    public List<Livro> findAll() {
        return livroRepository.findAll();
    }

    public Livro findById(UUID id) {
        return livroRepository.findById(id).orElse(null);
    }
}

