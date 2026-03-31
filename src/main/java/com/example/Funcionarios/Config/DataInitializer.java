package com.example.Funcionarios.Config;

import com.example.Funcionarios.Entity.Funcionario;
import com.example.Funcionarios.Enum.Role;
import com.example.Funcionarios.Repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        if (funcionarioRepository.findByNome("admin").isEmpty()) {
            Funcionario admin = new Funcionario();
            admin.setNome("admin");
            admin.setCpf("00000000000");
            admin.setSenha(passwordEncoder.encode("admin123"));
            admin.setPapel(Role.ADMIN);
            admin.setSalario(0.0);
            funcionarioRepository.save(admin);
        }
    }
}