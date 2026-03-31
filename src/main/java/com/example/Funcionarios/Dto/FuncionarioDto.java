package com.example.Funcionarios.Dto;


import com.example.Funcionarios.Enum.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FuncionarioDto {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private Role papel;
    private Double salario;
    private String setor;
    private Boolean ativo;
    private String cargo;

}
