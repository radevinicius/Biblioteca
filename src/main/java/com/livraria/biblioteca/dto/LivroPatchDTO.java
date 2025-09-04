package com.livraria.biblioteca.dto;

import com.livraria.biblioteca.model.LivroEntity;

public class LivroPatchDTO {
    private String nomeLivro;
    private String autor;
    private String genero;

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void aplicarEm(LivroEntity livro) {
        if (nomeLivro != null) livro.setNomeLivro(nomeLivro);
        if (autor != null) livro.setAutor(autor);
        if (genero != null) livro.setGenero(genero);
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
