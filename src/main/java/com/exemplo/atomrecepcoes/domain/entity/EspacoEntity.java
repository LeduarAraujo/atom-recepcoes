package com.exemplo.atomrecepcoes.domain.entity;

import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Id;

@Data
@Entity
@Table(name = "ESPACOFESTA")
public class EspacoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cdespaco")
    Long cdEspaco;

    @Column(name = "nmespaco")
    String nmEspaco;

    @Column(name = "dsendereco")
    String dsEndereco;

    @Column(name = "logoespaco")
    byte[] logoEspaco;
}
