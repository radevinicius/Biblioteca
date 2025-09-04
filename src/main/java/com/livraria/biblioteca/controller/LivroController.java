package com.livraria.biblioteca.controller;

import com.livraria.biblioteca.dto.LivroPatchDTO;
import com.livraria.biblioteca.mapper.LivroMapper;
import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.repository.LivroRepository;
import com.livraria.biblioteca.service.LivroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(name = "/livros")
public class LivroController {

    private final LivroRepository livroRepository;

    private final LivroService livroService;

    private final LivroMapper livroMapper;

    public LivroController(LivroRepository livroRepository, LivroService livroService, LivroMapper livroMapper) {
        this.livroRepository = livroRepository;
        this.livroService = livroService;
        this.livroMapper = livroMapper;
    }

    @PostMapping("/cadastrar")
    public LivroEntity cadastrarLivro(@RequestBody LivroPatchDTO livroPatchDTO){
        LivroEntity livroDto = livroMapper.toEntity(livroPatchDTO);
        return livroService.cadastrarLivro(livroDto);
    }
    @GetMapping("/listar")
    public List<LivroPatchDTO> listarLivro(){
        return livroService.listarLivros()
                .stream()
                .map(livroMapper::toDto).collect(Collectors.toList());
    }
    @GetMapping("/listar/{id}")
        public LivroPatchDTO listarLivroPorId(@PathVariable Long id){
            LivroEntity entity = livroService.listarLivroPorId(id);
            return livroMapper.toDto(entity);
        }
    @DeleteMapping("/deletar/{id}")
    public void deletarLivroPorId(@PathVariable Long id){
        livroService.deletarLivroPorId(id);
    }
    @PatchMapping("/atualizar/{id}")
    public LivroPatchDTO atualizarLivro(@PathVariable Long id, @RequestBody LivroPatchDTO dto){
        LivroEntity livroBuscar = livroService.listarLivroPorId(id);
        dto.aplicarEm(livroBuscar);
        LivroEntity atualizado = livroService.cadastrarLivro(livroBuscar);
        return livroMapper.toDto(atualizado);
    }

}
