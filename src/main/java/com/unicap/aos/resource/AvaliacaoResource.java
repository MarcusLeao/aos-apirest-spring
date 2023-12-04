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

import com.unicap.aos.domain.dto.AvaliacaoDTO;
import com.unicap.aos.domain.dto.ResponseDTO;
import com.unicap.aos.service.AvaliacaoService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/avaliacao")
@RequiredArgsConstructor
public class AvaliacaoResource {
    
     private final AvaliacaoService avaliacaoService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<AvaliacaoDTO>>> getAll(){

        return ResponseEntity.ok(new ResponseDTO<>(avaliacaoService.getAll()));
    } 

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO<AvaliacaoDTO>> getById(@PathVariable Long id){

        return ResponseEntity.ok(new ResponseDTO<>(avaliacaoService.findById(id)));
    }

    @PostMapping
    public ResponseEntity<ResponseDTO<AvaliacaoDTO>> create(@RequestBody @Valid AvaliacaoDTO filmeDTO){

        return ResponseEntity.ok(new ResponseDTO<>(avaliacaoService.create(filmeDTO)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){

        avaliacaoService.delete(id);

        return ResponseEntity.noContent().build();

    }
    
}
