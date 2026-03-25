package com.example.Funcionarios.Service;


import com.example.Funcionarios.Entity.Funcionario;
import com.example.Funcionarios.Repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;


    public FuncionarioService( FuncionarioRepository funcionarioRepository){
        this.funcionarioRepository = funcionarioRepository;
    }

    public Funcionario salvar(Funcionario funcionario){
        if(funcionarioRepository.existsByCpf(funcionario.getCpf())){
            throw new RuntimeException("CPF já cadastrado");
        }
        if (funcionario.getSalario() < 0){
            throw new RuntimeException("Salario invalido");
        }
        return funcionarioRepository.save(funcionario);

    }

    public void desativar(Long Id){
        Funcionario f = funcionarioRepository.findById(Id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        f.setAtivo(false);
        funcionarioRepository.save(f);
    }
    public List<Funcionario> listar (){
        return funcionarioRepository.findAll();
    }


    public Funcionario atualizar(Long id, Funcionario funcionario){
        Funcionario f = funcionarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));


        if(funcionario.getSalario() < 0){
            throw new RuntimeException("Salário inválido");
        }
        if(funcionario.getNome() != null){
            f.setNome(funcionario.getNome());
        }
        if(funcionario.getSalario() != null){
            if(funcionario.getSalario() < 0){
                throw new RuntimeException("Salário inválido");
            }
            f.setSalario(funcionario.getSalario());
        }
        if (funcionario.getTelefone()!= null){
            f.setTelefone(funcionario.getTelefone());
        }
        if(funcionario.getSetor() != null){
            f.setSetor(funcionario.getSetor());
        }

        if(funcionario.getCargo() != null){
            f.setCargo(funcionario.getCargo());
        }

        return funcionarioRepository.save(f);

    }


}
