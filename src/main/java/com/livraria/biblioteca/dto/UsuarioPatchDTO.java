package com.livraria.biblioteca.dto;

import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.model.UsuarioEntity;

public class UsuarioPatchDTO {
    private String nome;
    private String email;

    public UsuarioPatchDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public void aplicarEm(UsuarioEntity usuario) {
        if (nome != null) usuario.setNome(nome);
        if (email != null) usuario.setEmail(email);

    }

    public UsuarioPatchDTO() {

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
}
