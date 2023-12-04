package com.unicap.aos.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.unicap.aos.domain.dto.AvaliacaoDTO;
import com.unicap.aos.domain.entity.Avaliacao;
import com.unicap.aos.domain.entity.Filme;
import com.unicap.aos.exception.NotFoundException;
import com.unicap.aos.repository.AvaliacaoRepository;
import com.unicap.aos.repository.FilmeRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AvaliacaoService {

    private final AvaliacaoRepository avaliacaoRepository;
    private final FilmeRepository filmeRepository;

    public AvaliacaoDTO create(AvaliacaoDTO avaliacaoDTO){

        Optional<Filme> filme = filmeRepository.findById(avaliacaoDTO.getFilmeId()); 

        if (filme.isEmpty()) {
            throw new NotFoundException(Filme.class , avaliacaoDTO.getFilmeId());
        }
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setFilme(filme.get());
        avaliacao.setComentary(avaliacaoDTO.getCommentary());
        avaliacao.setDate(avaliacaoDTO.getDate());
        avaliacao.setScore(avaliacaoDTO.getScore());

        Avaliacao avaliacaoSave = avaliacaoRepository.save(avaliacao);

        return new AvaliacaoDTO(avaliacaoSave);
    }

    public AvaliacaoDTO update(Long id, AvaliacaoDTO avaliacaoDTO) {
     

        Optional<Avaliacao> searchedAvaliacao = avaliacaoRepository.findById(id);
        if (searchedAvaliacao.isEmpty()) throw new NotFoundException(Avaliacao.class,id);

        Avaliacao foundAvaliacao = searchedAvaliacao.get();

        if (avaliacaoDTO.getCommentary() != null)
            if (!avaliacaoDTO.getCommentary().isBlank()) foundAvaliacao.setComentary(avaliacaoDTO.getCommentary().trim());
        if (avaliacaoDTO.getDate() != null)
            foundAvaliacao.setDate(avaliacaoDTO.getDate());
        if (avaliacaoDTO.getScore() != null)
            foundAvaliacao.setScore(avaliacaoDTO.getScore());
        if (avaliacaoDTO.getFilmeId() != null) {
           Optional<Filme> filme = filmeRepository.findById(avaliacaoDTO.getFilmeId()); 

            if (filme.isEmpty()) {
                throw new NotFoundException(Filme.class , avaliacaoDTO.getFilmeId());
            }
            foundAvaliacao.setFilme(filme.get());
        } 

        Avaliacao avaliacaoSave = avaliacaoRepository.save(foundAvaliacao);

        return new AvaliacaoDTO(avaliacaoSave);
    }

    public List<AvaliacaoDTO> getAll(){
        
        List<Avaliacao> listAvaliacao = avaliacaoRepository.findAll();

        return listAvaliacao.stream().map(avaliacao -> new AvaliacaoDTO(avaliacao)).collect(Collectors.toList());
    }

    public AvaliacaoDTO findById(Long id){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);

        if (avaliacao.isEmpty()) {
            throw new NotFoundException(Avaliacao.class, id);
        }

        return new AvaliacaoDTO(avaliacao.get());
    }

    public void delete(Long id){
        Optional<Avaliacao> avaliacao = avaliacaoRepository.findById(id);

         if (avaliacao.isEmpty()) {
            throw new NotFoundException(Avaliacao.class, id);
        }

        avaliacaoRepository.delete(avaliacao.get());
    }
    
}
