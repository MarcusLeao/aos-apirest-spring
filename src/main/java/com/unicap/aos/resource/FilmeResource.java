package com.unicap.aos.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unicap.aos.domain.dto.FilmeDTO;
import com.unicap.aos.domain.dto.ResponseDTO;
import com.unicap.aos.service.FilmeService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/filme")
@RequiredArgsConstructor
public class FilmeResource {

    private final FilmeService filmeService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<FilmeDTO>>> getAll(){

        return ResponseEntity.ok(new ResponseDTO<>(filmeService.getAll()));
    } 

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO<FilmeDTO>> getById(@PathVariable Long id){

        return ResponseEntity.ok(new ResponseDTO<>(filmeService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<FilmeDTO>> create(@RequestBody @Valid FilmeDTO filmeDTO){

        return ResponseEntity.ok(new ResponseDTO<>(filmeService.create(filmeDTO)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        filmeService.delete(id);

        return ResponseEntity.noContent().build();

    }
    
}
