package com.as.gerenciamento_tarefas.controllers;

import com.as.gerenciamento_tarefas.models.TarefaModel;
import com.as.gerenciamento_tarefas.services.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> criar(@RequestBody TarefaModel tarefaModel){
        TarefaModel tarefa = tarefaService.criar(tarefaModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(tarefaModel.getId())
                .toUri();
        return ResponseEntity.created(uri).body(tarefa);
    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> listar() {
        List<TarefaModel> tarefas = tarefaService.listar();
        return ResponseEntity.ok().body(tarefas);
    }

    @GetMapping("/{id}")
    public Optional<TarefaModel> buscarId(@PathVariable Long id) {
        return tarefaService.buscarId(id);
    }

    @PutMapping("/{id}")
    public TarefaModel atualizar(@PathVariable Long id, @RequestBody TarefaModel tarefaModel) {
        return tarefaService.atualizar(id, tarefaModel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        tarefaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
