package com.unicap.aos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.unicap.aos.domain.dto.CategoriaDTO;
import com.unicap.aos.domain.entity.Categoria;
import com.unicap.aos.exception.NotFoundException;
import com.unicap.aos.repository.CategoriaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {
    
    private final CategoriaRepository categoriaRepository;

    public CategoriaDTO create(CategoriaDTO categoriaDTO){

        Categoria categoria = new Categoria();
        categoria.setName(categoriaDTO.getName());

        Categoria categoriaSave = categoriaRepository.save(categoria);

        return new CategoriaDTO(categoriaSave);
    }

    public List<CategoriaDTO> getAll(){
        
        List<Categoria> listCategoria = categoriaRepository.findAll();

        return listCategoria.stream().map(categoria -> new CategoriaDTO(categoria)).collect(Collectors.toList());
    }

    public CategoriaDTO findById(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isEmpty()) {
            throw new NotFoundException(Categoria.class, id);
        }

        return new CategoriaDTO(categoria.get());
    }

    public void delete(Long id){
        Optional<Categoria> categoria = categoriaRepository.findById(id);

         if (categoria.isEmpty()) {
            throw new NotFoundException(Categoria.class, id);
        }

        categoriaRepository.delete(categoria.get());
    }


}
