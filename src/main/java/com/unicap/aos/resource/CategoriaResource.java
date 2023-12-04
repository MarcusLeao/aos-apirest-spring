package com.unicap.aos.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.aos.domain.dto.CategoriaDTO;
import com.unicap.aos.domain.dto.FilmeDTO;
import com.unicap.aos.domain.dto.ResponseDTO;
import com.unicap.aos.service.CategoriaService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/categoria")
@RequiredArgsConstructor
public class CategoriaResource {
    
     private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<CategoriaDTO>>> getAll(){

        return ResponseEntity.ok(new ResponseDTO<>(categoriaService.getAll()));
    } 

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO<CategoriaDTO>> getById(@PathVariable Long id){

        return ResponseEntity.ok(new ResponseDTO<>(categoriaService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<CategoriaDTO>> create(@RequestBody @Valid CategoriaDTO categoriaDTO){

        return ResponseEntity.ok(new ResponseDTO<>(categoriaService.create(categoriaDTO)));
    }
    @PutMapping
    public ResponseEntity<ResponseDTO<CategoriaDTO>> update(@PathVariable Long id,@RequestBody @Valid CategoriaDTO categoriaDTO){

        return ResponseEntity.ok(new ResponseDTO<>(categoriaService.update(id,categoriaDTO)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        categoriaService.delete(id);

        return ResponseEntity.noContent().build();

    }
}
