package com.livraria.biblioteca.service;

import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.model.UsuarioEntity;
import com.livraria.biblioteca.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public UsuarioEntity cadastrarUsuario(UsuarioEntity usuarioEntity){
        return usuarioRepository.save(usuarioEntity);
    }
    public List<UsuarioEntity> listarUsuario(){
        return usuarioRepository.findAll();
    }
    public UsuarioEntity listarUsuarioPorId(@PathVariable Long id){
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("O usuario com " +id + " não foi encontrado" ));
    }
    public void deletarUsuarioPorId(@PathVariable Long id){
        usuarioRepository.deleteById(id);
    }
}
