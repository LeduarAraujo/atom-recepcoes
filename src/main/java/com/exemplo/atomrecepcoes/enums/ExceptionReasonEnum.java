package com.exemplo.atomrecepcoes.enums;


import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import com.exemplo.atomrecepcoes.exceptions.*;

@AllArgsConstructor
@Getter
public enum ExceptionReasonEnum {
    // LOGIN_INEXISTENTE(LoginSenhaException.class, HttpStatus.UNPROCESSABLE_ENTITY, "Invalid login or password"),
    LOGIN_JA_EXISTE_NA_BASE(LoginExistenteException.class, HttpStatus.CONFLICT, "Login already exists"),
    // EMAIL_JA_EXISTE_NA_BASE(EmailExistenteException.class, HttpStatus.CONFLICT, "Email already exists"),
    // USUARIO_NAO_ENCONTRADO(UsuarioNaoEncontradoException.class, HttpStatus.BAD_REQUEST, "Usuário não encontrado"),
    CAMPO_NAO_PREENCHIDO(CampoVazioException.class, HttpStatus.BAD_REQUEST, "Missing fields"),
    TOKEN_INVALIDO(MalformedJwtException.class, HttpStatus.UNAUTHORIZED, "Unauthorized"),
    TOKEN_EXPIRADO(ExpiredJwtException.class,HttpStatus.UNAUTHORIZED, "Unauthorized - invalid session")
    ;
    @SuppressWarnings("rawtypes")
    private Class exception;
    private HttpStatus statusCode;
    private String dsError;

    public static ExceptionReasonEnum getEnum(@SuppressWarnings("rawtypes") Class param) {
        for (ExceptionReasonEnum valor : values()) {
            if (valor.exception == param) {
                return valor;
            }
        }
        return null;
    }
}