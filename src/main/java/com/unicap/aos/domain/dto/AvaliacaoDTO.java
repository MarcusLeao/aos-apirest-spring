package com.unicap.aos.domain.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.unicap.aos.domain.entity.Avaliacao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class AvaliacaoDTO {
    
    private Long id;
    @NotNull
    @Min(1)
    @Max(10)
    private Integer score;

    private String commentary;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonProperty("filme_id")
    private Long filmeId;

    public AvaliacaoDTO(Avaliacao avaliacao){

        this.id = avaliacao.getId();
        this.filmeId = avaliacao.getFilme().getId();
        this.score = avaliacao.getScore();
        this.commentary = avaliacao.getComentary();
        this.date = avaliacao.getDate();
        
    }

}