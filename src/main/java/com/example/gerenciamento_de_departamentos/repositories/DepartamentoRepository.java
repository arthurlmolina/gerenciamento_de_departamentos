package com.example.gerenciamento_de_departamentos.repositories;

import com.example.gerenciamento_de_departamentos.models.DepartamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepository extends JpaRepository<DepartamentoModel, Long> {
}
