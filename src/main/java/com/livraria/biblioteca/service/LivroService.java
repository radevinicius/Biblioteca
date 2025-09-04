package com.livraria.biblioteca.service;

import com.livraria.biblioteca.model.LivroEntity;
import com.livraria.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }
    public LivroEntity cadastrarLivro(LivroEntity livroEntity){
        return livroRepository.save(livroEntity);
    }
    public List<LivroEntity> listarLivros(){
        return livroRepository.findAll();
    }
    public LivroEntity listarLivroPorId(@PathVariable Long id){
        return livroRepository.findById(id).orElseThrow(() -> new RuntimeException("O livro com " +id + " não foi encontrado" ));
    }
    public void deletarLivroPorId(@PathVariable Long id){
        livroRepository.deleteById(id);
    }

}
