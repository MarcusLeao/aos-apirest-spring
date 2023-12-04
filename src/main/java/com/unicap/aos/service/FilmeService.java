package com.unicap.aos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.unicap.aos.domain.dto.FilmeDTO;
import com.unicap.aos.domain.entity.Categoria;
import com.unicap.aos.domain.entity.Filme;
import com.unicap.aos.exception.NotFoundException;
import com.unicap.aos.repository.CategoriaRepository;
import com.unicap.aos.repository.FilmeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final CategoriaRepository categoriaRepository;

    public FilmeDTO create(FilmeDTO filmeDTO){

        Optional<Categoria> categoria = categoriaRepository.findById(filmeDTO.getCategoryId()); 

        if (categoria.isEmpty()) {
            throw new NotFoundException(Categoria.class , filmeDTO.getCategoryId());
        }
        Filme filme = new Filme();
        filme.setCategory(categoria.get());
        filme.setName(filmeDTO.getName());
        filme.setDuration(filmeDTO.getDuration());
        filme.setReleaseYear(filmeDTO.getReleaseYear());

        Filme filmeSave = filmeRepository.save(filme);

        return new FilmeDTO(filmeSave);
    }

    public List<FilmeDTO> getAll(){
        
        List<Filme> listFilme = filmeRepository.findAll();

        return listFilme.stream().map(filme -> new FilmeDTO(filme)).collect(Collectors.toList());
    }

    public FilmeDTO findById(Long id){
        Optional<Filme> filme = filmeRepository.findById(id);

        if (filme.isEmpty()) {
            throw new NotFoundException(Filme.class, id);
        }

        return new FilmeDTO(filme.get());
    }

    public void delete(Long id){
        Optional<Filme> filme = filmeRepository.findById(id);

         if (filme.isEmpty()) {
            throw new NotFoundException(Filme.class, id);
        }

        filmeRepository.delete(filme.get());
    }
    
}
