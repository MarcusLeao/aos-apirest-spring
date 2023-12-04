package com.unicap.aos.domain.dto;

import com.unicap.aos.domain.entity.Filme;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
    @Min(value = 1955)
    @Max(value = 9999)
    private Long releaseYear;
    @NotNull(message = "É necessario criar a categoria antes do filme!")
    private Long categoryId;

    public FilmeDTO(Filme filme){

        this.id = filme.getId();
        this.categoryId = filme.getCategory().getId();
        this.name = filme.getName();
        this.duration = filme.getDuration();
        this.releaseYear = filme.getReleaseYear();
        
    }

}
