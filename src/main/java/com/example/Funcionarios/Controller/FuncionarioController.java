package com.example.Funcionarios.Controller;


import com.example.Funcionarios.Entity.Funcionario;
import com.example.Funcionarios.Service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController (FuncionarioService funcionarioService) {
    this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public ResponseEntity<Funcionario> funcionarioSalvar(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(201).body(funcionarioService.salvar(funcionario));
    }

    @GetMapping
    public List<Funcionario> funcionarioListar(){
        return funcionarioService.listar();
    }

    @PutMapping("/{id}")
    public Funcionario funcionarioAtualizar(@PathVariable long id, @RequestBody Funcionario funcionario){
        return funcionarioService.atualizar(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> desativar (@PathVariable Long id){
        funcionarioService.desativar(id);
        return ResponseEntity.noContent().build();
    }

}
