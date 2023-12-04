package com.unicap.aos.domain.dto;

import com.unicap.aos.domain.entity.Filme;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FilmeDTO {

    private Long id;
    private String name;
    private Long duration;
    private Long releaseYear;
    private Long categoryId;

    public FilmeDTO(Filme filme){

        this.id = filme.getId();
        this.categoryId = filme.getCategory().getId();
        this.name = filme.getName();
        this.duration = filme.getDuration();
        this.releaseYear = filme.getReleaseYear();
        
    }

}
