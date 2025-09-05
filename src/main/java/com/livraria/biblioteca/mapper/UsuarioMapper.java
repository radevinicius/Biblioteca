package com.livraria.biblioteca.mapper;

import com.livraria.biblioteca.dto.UsuarioPatchDTO;
import com.livraria.biblioteca.model.UsuarioEntity;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {

    public UsuarioPatchDTO toDto(UsuarioEntity entity) {
        UsuarioPatchDTO dto = new UsuarioPatchDTO();
        dto.setFirebaseUid(entity.getFirebaseUid());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setFotoPerfilUrl(entity.getFotoPerfilUrl());
        dto.setDataCadastro(entity.getDataCadastro());
        dto.setUltimoLogin(entity.getUltimoLogin());
        dto.setRole(entity.getRole());
        dto.setAtivo(entity.getAtivo());
        return dto;
    }

    public UsuarioEntity toEntity(UsuarioPatchDTO dto) {
        UsuarioEntity entity = new UsuarioEntity();
        dto.aplicarEm(entity);
        return entity;
    }
}