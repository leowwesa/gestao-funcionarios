package com.example.Funcionarios.Repository;

import com.example.Funcionarios.Entity.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    boolean existsByCpf(String cpf);
    Optional<Funcionario> findByNome(String nome);
}
