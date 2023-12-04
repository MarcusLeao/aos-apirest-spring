package com.unicap.aos.domain.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    private Integer codigo;
    private String mensagem;
    private T conteudo;

    public ResponseDTO(T conteudo){

        this.codigo = 200;
        this.mensagem = "Sucesso";
        this.conteudo = conteudo;
    }

    public ResponseDTO(Integer codigo, String mensagem){

        this.codigo = codigo;
        this.mensagem = mensagem;
        this.conteudo = null;
    }
    
}
