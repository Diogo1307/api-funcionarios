package com.example.funcionarioapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.funcionarioapi.model.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    // Métodos de consulta personalizados podem ser adicionados aqui se necessário
}
