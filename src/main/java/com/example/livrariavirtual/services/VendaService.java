package com.example.livrariavirtual.services;

import com.example.livrariavirtual.models.Venda;
import com.example.livrariavirtual.repositories.VendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VendaService {
    @Autowired
    private VendaRepository vendaRepository;

    public Venda save(Venda venda) {
        return vendaRepository.save(venda);
    }

    public List<Venda> findAll() {
        return vendaRepository.findAll();
    }

    public Venda findById(UUID id) {
        return vendaRepository.findById(id).orElse(null);
    }
}

