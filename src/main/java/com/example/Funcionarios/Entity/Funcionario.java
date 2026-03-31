package com.example.Funcionarios.Entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import com.example.Funcionarios.Enum.Role;


@Entity
@Getter
@Setter
@Table (name = "funcionarios")

public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    //Identificação
    private Long id;


    //Dados pessoais
    @Column(nullable = false)
    private String nome;
    @Column(unique = true, nullable = false)
    private String cpf;
    private String telefone;
    private String email;
    private String senha;
    @Enumerated(EnumType.STRING)
    private Role papel;

    //Dados profissionais
    private Double salario;
    private String setor;
    private Boolean ativo;
    private String cargo;


    //Controle
    private LocalDateTime criadoEm;
    @PrePersist
    public void prePersist() {
        this.criadoEm = LocalDateTime.now();
        this.ativo = true;

    }
    private LocalDateTime atualizadoEm;
    @PreUpdate
    public void preUpdate(){
        this.atualizadoEm = LocalDateTime.now();
    }
}