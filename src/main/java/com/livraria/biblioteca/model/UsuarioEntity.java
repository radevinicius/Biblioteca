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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<LivroEntity> getLivrosAlugados() {
        return livrosAlugados;
    }

    public void setLivrosAlugados(List<LivroEntity> livrosAlugados) {
        this.livrosAlugados = livrosAlugados;
    }
}
