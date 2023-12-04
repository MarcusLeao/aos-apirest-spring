package com.unicap.aos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unicap.aos.domain.entity.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme,Long> {} 