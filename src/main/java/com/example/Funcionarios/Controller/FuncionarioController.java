package com.example.Funcionarios.Controller;


import com.example.Funcionarios.Dto.FuncionarioDto;
import com.example.Funcionarios.Entity.Funcionario;
import com.example.Funcionarios.Service.FuncionarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    public FuncionarioController (FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
    @PostMapping
    public ResponseEntity<Funcionario> funcionarioSalvar(@RequestBody Funcionario funcionario){
        return ResponseEntity.status(201).body(funcionarioService.salvar(funcionario));
    }

    @GetMapping
    public List<FuncionarioDto> funcionarioListar(){
        return funcionarioService.listar()
                .stream()
                .map(f -> {
                    FuncionarioDto dto = new FuncionarioDto();
                    dto.setId(f.getId());
                    dto.setNome(f.getNome());
                    dto.setCpf(f.getCpf());
                    dto.setTelefone(f.getTelefone());
                    dto.setEmail(f.getEmail());
                    dto.setPapel(f.getPapel());
                    dto.setSalario(f.getSalario());
                    dto.setSetor(f.getSetor());
                    dto.setAtivo(f.getAtivo());
                    dto.setCargo(f.getCargo());
                    return dto;
                })
                .toList();
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('RH') or #id == authentication.principal.id")
    @PutMapping("/{id}")
    public Funcionario funcionarioAtualizar(@PathVariable long id, @RequestBody Funcionario funcionario, Authentication authentication){
        return funcionarioService.atualizar(id, funcionario);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('RH')")
    @DeleteMapping("/{id}/desativar")
    public ResponseEntity<Void> desativar (@PathVariable Long id){
        funcionarioService.desativar(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar (@PathVariable Long id){
        funcionarioService.deletar(id);
        return ResponseEntity.noContent().build();

    }

}


