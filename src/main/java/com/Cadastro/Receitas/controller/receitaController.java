package com.Cadastro.Receitas.controller;

import com.Cadastro.Receitas.ReceitasApplication;
import com.Cadastro.Receitas.models.Receita;
import com.Cadastro.Receitas.service.receitaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
@RequestMapping("/receitas")
public class receitaController {
    private receitaService receitaService;

    public receitaController(receitaService receitaService) {
        this.receitaService = receitaService;
    }

    @GetMapping
    public List<Receita> listar() {
        return receitaService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> Salvar(@Valid @RequestBody Receita receita) {
        receitaService.salvar(receita);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("Mensagem:", "Receita Salvo com sucesso!"));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> atualizar(@Valid @RequestBody Receita receita) {
        receitaService.atualizar(receita);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem:", "Receita Atualizada com sucesso!"));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Map<String, Object>> deletar(@PathVariable long id) {
        receitaService.remover(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(Map.of("Mensagem:", "Receita Excluida com sucesso!"));
    }
}
