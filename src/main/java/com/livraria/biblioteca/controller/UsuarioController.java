package com.livraria.biblioteca.controller;

import com.livraria.biblioteca.dto.LivroPatchDTO;
import com.livraria.biblioteca.dto.UsuarioPatchDTO;
import com.livraria.biblioteca.mapper.UsuarioMapper;
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

    private UsuarioMapper usuarioMapper;

    @PostMapping("/cadastrar")
    public ResponseEntity<UsuarioPatchDTO> cadastrarUsuario(@RequestBody UsuarioPatchDTO usuarioPatchDTO){
        UsuarioEntity usuarioEntity = usuarioMapper.toEntity(usuarioPatchDTO);
        usuarioService.cadastrarUsuario(usuarioEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(usuarioEntity));
    }
    @GetMapping("/listar")
    public ResponseEntity<List<UsuarioPatchDTO>> listarUsuarios(){
        return ResponseEntity.status(HttpStatus.FOUND).body(usuarioService.listarUsuario()
                .stream()
                .map(usuarioMapper::toDto).collect(Collectors.toList()));
    }
    @GetMapping("/listar/{id}")
    public ResponseEntity<UsuarioPatchDTO> listarLivroPorId(@PathVariable Long id){
        UsuarioEntity entity = usuarioService.listarUsuarioPorId(id);
        return ResponseEntity.ok(usuarioMapper.toDto(entity));
    }
    @DeleteMapping("/deletar/{id}")
    public void deletarLivroPorId(@PathVariable Long id){
        usuarioService.deletarUsuarioPorId(id);
    }
    @PatchMapping("/atualizar/{id}")
    public ResponseEntity<UsuarioPatchDTO> atualizarLivro(@PathVariable Long id, @RequestBody LivroPatchDTO dto){
        UsuarioEntity livroBuscar = usuarioService.listarUsuarioPorId(id);
       // dto.aplicarEm(livroBuscar);
        UsuarioEntity atualizado = usuarioService.cadastrarUsuario(livroBuscar);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioMapper.toDto(atualizado));
    }
}
