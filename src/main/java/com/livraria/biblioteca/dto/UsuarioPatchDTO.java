package com.livraria.biblioteca.dto;

public class UsuarioPatchDTO {
    private String nome;
    private String email;

    public UsuarioPatchDTO(String nome, String email) {
        this.nome = nome;
        this.email = email;
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
