package com.unicap.aos.domain.dto;

import com.unicap.aos.domain.entity.Categoria;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoriaDTO {

    private Long id;

    @NotBlank(message = "É necessario ter o nome da categoria!")
    private String name;

    public CategoriaDTO(Categoria categoria){

        this.id = categoria.getId();
        this.name = categoria.getName();
 
    }
    
}
