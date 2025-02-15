package com.exemplo.atomrecepcoes.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baeldung.openapi.model.ListaEspacosResponseRepresentation;
import com.baeldung.openapi.model.SucessMessageRepresentation;
import com.exemplo.atomrecepcoes.mapper.EspacoMapper;
import com.exemplo.atomrecepcoes.repository.EspacosRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class AgendaRecepcoesService {
    
    //TODO: Chamar os repositórios aqui, ps. Os repositórios são interfaces que estendem JpaRepository
    private final EspacosRepository espacosRepository;

    public SucessMessageRepresentation incluirEspaco(String tokenJwt, Long idFuncionario,
    String nmEspaco, String dsEndereco, String instagram, MultipartFile logoEspaco) {
        log.info("Incluindo espaço");

        espacosRepository.save(EspacoMapper.representationToEntity(nmEspaco, dsEndereco, instagram, logoEspaco));
        return SucessMessageRepresentation.builder()
                .message("Cadastrado com sucesso")
                .code(0)
                .build();
    }

    public ListaEspacosResponseRepresentation listarEspacos(String tokenJwt, Long idFuncionario) {
        log.info("Listando espaços");
        return ListaEspacosResponseRepresentation.builder()
                .listaEspacos(EspacoMapper.entityToRepresentation(espacosRepository.findAll()))
                .build();
    }
    
}
