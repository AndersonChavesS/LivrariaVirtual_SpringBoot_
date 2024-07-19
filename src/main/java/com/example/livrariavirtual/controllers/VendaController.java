package com.example.livrariavirtual.controllers;

import com.example.livrariavirtual.models.Venda;
import com.example.livrariavirtual.services.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/vendas")
public class VendaController {
    @Autowired
    private VendaService vendaService;

    @PostMapping
    public ResponseEntity<EntityModel<Venda>> createVenda(@RequestBody Venda venda) {
        Venda savedVenda = vendaService.save(venda);
        EntityModel<Venda> vendaResource = EntityModel.of(savedVenda);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaController.class).getVenda(savedVenda.getId())).withSelfRel();
        vendaResource.add(selfLink);
        return ResponseEntity.ok(vendaResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Venda>> getVenda(@PathVariable UUID id) {
        Venda venda = vendaService.findById(id);
        if (venda == null) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<Venda> vendaResource = EntityModel.of(venda);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaController.class).getVenda(id)).withSelfRel();
        vendaResource.add(selfLink);
        return ResponseEntity.ok(vendaResource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Venda>>> getAllVendas() {
        List<Venda> vendas = vendaService.findAll();
        List<EntityModel<Venda>> vendaResources = vendas.stream().map(venda -> {
            EntityModel<Venda> resource = EntityModel.of(venda);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(VendaController.class).getVenda(venda.getId())).withSelfRel();
            resource.add(selfLink);
            return resource;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(vendaResources);
    }
}
