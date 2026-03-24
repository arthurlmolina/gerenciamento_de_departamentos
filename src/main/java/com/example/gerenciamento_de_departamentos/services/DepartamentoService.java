package com.example.gerenciamento_de_departamentos.services;

import com.example.gerenciamento_de_departamentos.models.DepartamentoModel;
import com.example.gerenciamento_de_departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    DepartamentoRepository departamentoRepository;

    public List<DepartamentoModel> findAll(){
        return departamentoRepository.findAll();
    }

    public Optional<DepartamentoModel> buscarPorId(Long id){
        return departamentoRepository.findById(id);
    }

    public DepartamentoModel criar(DepartamentoModel departamentoModel){
        return departamentoRepository.save(departamentoModel);
    }

    public DepartamentoModel atualizar(DepartamentoModel departamentoModel, Long id){
        DepartamentoModel departamento = departamentoRepository.findById(id).get();
        departamento.setNome(departamentoModel.getNome());
        return departamentoRepository.save(departamento);
    }

    public void deletar(Long id){
        departamentoRepository.deleteById(id);
    }
}
