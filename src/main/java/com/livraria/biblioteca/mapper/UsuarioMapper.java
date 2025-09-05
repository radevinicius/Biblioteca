package com.livraria.biblioteca.mapper;

import com.livraria.biblioteca.dto.UsuarioPatchDTO;
import com.livraria.biblioteca.model.UsuarioEntity;
import org.springframework.stereotype.Component;
@Component
public class UsuarioMapper {



    public UsuarioPatchDTO toDto(UsuarioEntity entity) {
        UsuarioPatchDTO dto = new UsuarioPatchDTO();
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public  UsuarioEntity toEntity(UsuarioPatchDTO dto) {
        UsuarioEntity entity = new UsuarioEntity();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
