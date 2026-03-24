package com.example.gerenciamento_de_departamentos.controllers;

import com.example.gerenciamento_de_departamentos.models.DepartamentoModel;
import com.example.gerenciamento_de_departamentos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public ResponseEntity<List<DepartamentoModel>> findAll(){
        List<DepartamentoModel> request = departamentoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> buscarPorId(@PathVariable Long id){
        return departamentoService.buscarPorId(id);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criar(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.criar(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(departamentoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping("/{id}")
    public DepartamentoModel atualizar(@RequestBody DepartamentoModel departamentoModel, @PathVariable Long id){
        return departamentoService.atualizar(departamentoModel,id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        departamentoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
