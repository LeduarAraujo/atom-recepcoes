package com.exemplo.atomrecepcoes.mapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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
                .siAtivo(resp.getSiAtivo())
                .instagram(resp.getInstagram())
                .logoEspaco(resp.getLogoEspaco())
                .build());
        });

        return resposta;
    }

    public static EspacoEntity representationToEntity(String nmEspaco, String dsEndereco,
        String instagram, MultipartFile logoEspaco) {   
        EspacoEntity espaco = new EspacoEntity();
        espaco.setNmEspaco(nmEspaco);
        espaco.setDsEndereco(dsEndereco);
        espaco.setSiAtivo("S");
        espaco.setInstagram(instagram);
        try {
            if (logoEspaco != null && logoEspaco.getBytes().length > 0) {
                espaco.setLogoEspaco(logoEspaco.getBytes());
            }
        } catch (IOException e) {
        }

        return espaco;
    }
}
