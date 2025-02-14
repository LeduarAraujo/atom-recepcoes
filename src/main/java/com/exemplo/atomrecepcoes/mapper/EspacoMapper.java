package com.exemplo.atomrecepcoes.mapper;

import java.util.ArrayList;
import java.util.List;

import com.baeldung.openapi.model.DadosEspacoRepresentation;
import com.exemplo.atomrecepcoes.domain.entity.EspacoEntity;

public class EspacoMapper {
    
    public static List<DadosEspacoRepresentation> entityToRepresentation(List<EspacoEntity> response) {

        List<DadosEspacoRepresentation> resposta = new ArrayList<>();

        response.forEach(resp -> {
            resposta.add(DadosEspacoRepresentation.builder()
                .cdEspaco(resp.getCdEspaco().intValue())
                .nmEspaco(resp.getNmEspaco())
                .dsEndereco(resp.getDsEndereco())
                .logoEspaco(resp.getLogoEspaco())
                .build());
        });

        return resposta;
    }
}
