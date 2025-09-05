package com.livraria.biblioteca.controller;

import com.livraria.biblioteca.dto.LivroPatchDTO;
import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.model.UsuarioEntity;
import com.livraria.biblioteca.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<LivroPatchDTO> cadastrarLivro(@RequestBody LivroPatchDTO livroPatchDTO){
        LivroEntity livroDto = livroMapper.toEntity(livroPatchDTO);
        usuarioService.cadastrarUsuario(livroDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroMapper.toDto(livroDto));
    }
    @GetMapping("/listar")
    public ResponseEntity<List<LivroPatchDTO>> listarLivro(){
        return ResponseEntity.status(HttpStatus.FOUND).body(usuarioService.listarUsuario()
                .stream()
                .map(livroMapper::toDto).collect(Collectors.toList()));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<LivroPatchDTO> listarLivroPorId(@PathVariable Long id){
        UsuarioEntity entity = usuarioService.listarUsuarioPorId();
        return ResponseEntity.ok(livroMapper.toDto(entity));
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarLivroPorId(@PathVariable Long id){
        usuarioService.deletarUsuarioPorId(id);
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<LivroPatchDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroPatchDTO dto){
        UsuarioEntity livroBuscar = usuarioService.listarUsuarioPorId(id);
       // dto.aplicarEm(livroBuscar);
        UsuarioEntity atualizado = usuarioService.cadastrarUsuario(livroBuscar);
        return ResponseEntity.status(HttpStatus.CREATED).body(livroMapper.toDto(atualizado));
    }
}
