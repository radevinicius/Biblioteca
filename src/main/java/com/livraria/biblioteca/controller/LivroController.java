package com.livraria.biblioteca.controller;

import com.livraria.biblioteca.dto.LivroPatchDTO;
import com.livraria.biblioteca.mapper.LivroMapper;
import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/livros")
public class LivroController {
@Autowired
    private final LivroService livroService;
@Autowired
    private final LivroMapper livroMapper;

    public LivroController(LivroService livroService, LivroMapper livroMapper) {
        this.livroService = livroService;
        this.livroMapper = livroMapper;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroPatchDTO> cadastrarLivro(@RequestBody LivroPatchDTO livroPatchDTO){
        LivroEntity livroDto = livroMapper.toEntity(livroPatchDTO);
        livroService.cadastrarLivro(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroMapper.toDto(livroDto));
    }
    @GetMapping("/listar")
    public ResponseEntity<List<LivroPatchDTO>> listarLivro(){
        return ResponseEntity.status(HttpStatus.FOUND).body(livroService.listarLivros()
                .stream()
                .map(livroMapper::toDto).collect(Collectors.toList()));
    }
    @GetMapping("/listar/{id}")
        public ResponseEntity<LivroPatchDTO> listarLivroPorId(@PathVariable Long id){
            LivroEntity entity = livroService.listarLivroPorId(id);
            return ResponseEntity.ok(livroMapper.toDto(entity));
        }
    @DeleteMapping("/deletar/{id}")
    public void deletarLivroPorId(@PathVariable Long id){
        livroService.deletarLivroPorId(id);
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<LivroPatchDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroPatchDTO dto){
        LivroEntity livroBuscar = livroService.listarLivroPorId(id);
        dto.aplicarEm(livroBuscar);
        LivroEntity atualizado = livroService.cadastrarLivro(livroBuscar);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroMapper.toDto(atualizado));
    }

}
