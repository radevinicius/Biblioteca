package com.livraria.biblioteca.dto;

import com.livraria.biblioteca.model.UsuarioEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UsuarioPatchDTO {

    private String firebaseUid;
    private String nome;
    private String email;
    private String fotoPerfilUrl;
    private LocalDate dataCadastro;
    private LocalDateTime ultimoLogin;
    private String role;
    private Boolean ativo;

    public UsuarioPatchDTO() {}

    public UsuarioPatchDTO(String firebaseUid, String nome, String email, String fotoPerfilUrl,
                           LocalDate dataCadastro, LocalDateTime ultimoLogin, String role, Boolean ativo) {
        this.firebaseUid = firebaseUid;
        this.nome = nome;
        this.email = email;
        this.fotoPerfilUrl = fotoPerfilUrl;
        this.dataCadastro = dataCadastro;
        this.ultimoLogin = ultimoLogin;
        this.role = role;
        this.ativo = ativo;
    }

    public void aplicarEm(UsuarioEntity usuario) {
        if (firebaseUid != null) usuario.setFirebaseUid(firebaseUid);
        if (nome != null) usuario.setNome(nome);
        if (email != null) usuario.setEmail(email);
        if (fotoPerfilUrl != null) usuario.setFotoPerfilUrl(fotoPerfilUrl);
        if (dataCadastro != null) usuario.setDataCadastro(dataCadastro);
        if (ultimoLogin != null) usuario.setUltimoLogin(ultimoLogin);
        if (role != null) usuario.setRole(role);
        if (ativo != null) usuario.setAtivo(ativo);
    }

    // Getters e Setters
    public String getFirebaseUid() { return firebaseUid; }
    public void setFirebaseUid(String firebaseUid) { this.firebaseUid = firebaseUid; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFotoPerfilUrl() { return fotoPerfilUrl; }
    public void setFotoPerfilUrl(String fotoPerfilUrl) { this.fotoPerfilUrl = fotoPerfilUrl; }

    public LocalDate getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(LocalDate dataCadastro) { this.dataCadastro = dataCadastro; }

    public LocalDateTime getUltimoLogin() { return ultimoLogin; }
    public void setUltimoLogin(LocalDateTime ultimoLogin) { this.ultimoLogin = ultimoLogin; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public Boolean getAtivo() { return ativo; }
    public void setAtivo(Boolean ativo) { this.ativo = ativo; }
}