package com.exemplo.atomrecepcoes.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.baeldung.openapi.api.ApiApi;
import com.baeldung.openapi.model.CadastroEspacoRequestRepresentation;
import com.baeldung.openapi.model.CadastroFuncionarioRequestRepresentation;
import com.baeldung.openapi.model.ListaEspacosResponseRepresentation;
import com.baeldung.openapi.model.SigninUsuarioRequestRepresentation;
import com.baeldung.openapi.model.SigninUsuarioResponseRepresentation;
import com.baeldung.openapi.model.SucessMessageRepresentation;
import com.exemplo.atomrecepcoes.service.AgendaRecepcoesService;
import com.exemplo.atomrecepcoes.utils.ErrorFormat;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class AgendaRecepcoesController implements ApiApi {

    private final AgendaRecepcoesService service;
    
    @Override
    public ResponseEntity<SigninUsuarioResponseRepresentation> iniciarSessao(
            SigninUsuarioRequestRepresentation signinUsuarioRequestRepresentation) {
        try {
            // return ResponseEntity.ok().body();
            return ApiApi.super.iniciarSessao(signinUsuarioRequestRepresentation);
        } catch (Exception ex) {
            return (ResponseEntity) ErrorFormat.convertToEntity(ex);
        }
    }

    @Override
    public ResponseEntity<SucessMessageRepresentation> cadastroFuncionario(String tokenJwt, Long idFuncionario,
            CadastroFuncionarioRequestRepresentation cadastroFuncionarioRequestRepresentation) {
        try {
            // return ResponseEntity.ok().body();
            return ApiApi.super.cadastroFuncionario(tokenJwt, idFuncionario, cadastroFuncionarioRequestRepresentation);
        } catch (Exception ex) {
            return (ResponseEntity) ErrorFormat.convertToEntity(ex);
        }
    }

    @Override
    public ResponseEntity<SucessMessageRepresentation> incluirEspaco(String tokenJwt, Long idFuncionario,
            CadastroEspacoRequestRepresentation cadastroEspacoRequestRepresentation) {
        try {
            // return ResponseEntity.ok().body();
            return ApiApi.super.incluirEspaco(tokenJwt, idFuncionario, cadastroEspacoRequestRepresentation);
        } catch (Exception ex) {
            return (ResponseEntity) ErrorFormat.convertToEntity(ex);
        } 
    }

    @Override
    public ResponseEntity<ListaEspacosResponseRepresentation> listarEspacos(String tokenJwt, Long idFuncionario) {
        try {
            return ResponseEntity.ok().body(service.listarEspacos(tokenJwt, idFuncionario));
        } catch (Exception ex) {
            return (ResponseEntity) ErrorFormat.convertToEntity(ex);
        }
    }
}
