package com.example.gerenciamento_de_departamentos.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_departamento")
public class DepartamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nomeDepartamento")
    private String nome;
    @Column(name = "localizacaoDepartamento")
    private String localizacao;

}
