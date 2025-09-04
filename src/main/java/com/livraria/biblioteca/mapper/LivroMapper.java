package com.livraria.biblioteca.mapper;

import com.livraria.biblioteca.dto.LivroPatchDTO;
import com.livraria.biblioteca.model.LivroEntity;
import org.springframework.stereotype.Component;

@Component
public class LivroMapper {

    public LivroPatchDTO toDto(LivroEntity entity) {
        LivroPatchDTO dto = new LivroPatchDTO();
        dto.setNomeLivro(entity.getNomeLivro());
        dto.setAutor(entity.getAutor());
        dto.setGenero(entity.getGenero());
        return dto;
    }

    public  LivroEntity toEntity(LivroPatchDTO dto) {
        LivroEntity entity = new LivroEntity();
        entity.setNomeLivro(dto.getNomeLivro());
        entity.setAutor(dto.getAutor());
        entity.setGenero(dto.getGenero());
        return entity;
    }
}