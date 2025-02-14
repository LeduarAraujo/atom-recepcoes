package com.exemplo.atomrecepcoes.repository;

import org.springframework.stereotype.Repository;

import com.exemplo.atomrecepcoes.domain.entity.EspacoEntity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EspacosRepository extends JpaRepository<EspacoEntity, Long> {

    @SuppressWarnings({ "null", "unchecked" })
    EspacoEntity save(EspacoEntity espaco);

    @SuppressWarnings("null")
    List<EspacoEntity> findAll();
    
}
