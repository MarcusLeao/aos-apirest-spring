package com.unicap.aos.domain.dto;

import com.unicap.aos.domain.entity.Filme;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmeDTO {

    private Long id;
    @NotBlank(message = "É necessario ter o nome do filme!")
    private String name;
    private Long duration;
    @NotNull
    @Size(min = 1955,max =  9999)
    private Long releaseYear;
    @NotNull
    private Long categoryId;

    public FilmeDTO(Filme filme){

        this.id = filme.getId();
        this.categoryId = filme.getCategory().getId();
        this.name = filme.getName();
        this.duration = filme.getDuration();
        this.releaseYear = filme.getReleaseYear();
        
    }

}
