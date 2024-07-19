package com.example.livrariavirtual.controllers;

import com.example.livrariavirtual.models.Livro;
import com.example.livrariavirtual.services.LivroService;
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
@RequestMapping("/livros")
public class LivroController {
    @Autowired
    private LivroService livroService;

    @PostMapping
    public ResponseEntity<EntityModel<Livro>> createLivro(@RequestBody Livro livro) {
        Livro savedLivro = livroService.save(livro);
        EntityModel<Livro> livroResource = EntityModel.of(savedLivro);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LivroController.class).getLivro(savedLivro.getId())).withSelfRel();
        livroResource.add(selfLink);
        return ResponseEntity.ok(livroResource);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<Livro>> getLivro(@PathVariable UUID id) {
        Livro livro = livroService.findById(id);
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        EntityModel<Livro> livroResource = EntityModel.of(livro);
        Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LivroController.class).getLivro(id)).withSelfRel();
        livroResource.add(selfLink);
        return ResponseEntity.ok(livroResource);
    }

    @GetMapping
    public ResponseEntity<List<EntityModel<Livro>>> getAllLivros() {
        List<Livro> livros = livroService.findAll();
        List<EntityModel<Livro>> livroResources = livros.stream().map(livro -> {
            EntityModel<Livro> resource = EntityModel.of(livro);
            Link selfLink = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(LivroController.class).getLivro(livro.getId())).withSelfRel();
            resource.add(selfLink);
            return resource;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(livroResources);
    }
}


