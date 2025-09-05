package com.livraria.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "usuario")
public class UsuarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    private String nome;
    @Column(unique = true, nullable = false)
    private String email;
    @OneToMany(mappedBy = "usuario")
    private List<LivroEntity> livrosAlugados;


}
