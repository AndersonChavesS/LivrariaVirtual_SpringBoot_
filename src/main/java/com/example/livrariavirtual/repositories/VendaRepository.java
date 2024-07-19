package com.example.livrariavirtual.repositories;

import com.example.livrariavirtual.models.Venda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VendaRepository extends JpaRepository<Venda, UUID> {
}
