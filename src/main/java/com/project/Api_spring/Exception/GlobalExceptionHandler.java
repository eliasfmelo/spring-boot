package com.project.Api_spring.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RecursoNaoEncontradoException.class)
    public ResponseEntity<ErroResponse> tratarRecursoNaoEncontrado(
            RecursoNaoEncontradoException ex, WebRequest request) {
        return construirResposta(HttpStatus.NOT_FOUND, "Recurso não encontrado",
                "O recurso solicitado não foi encontrado.");
    }

    @ExceptionHandler(RecursoDuplicadoException.class)
    public ResponseEntity<ErroResponse> tratarRecursoDuplicado(
            RecursoDuplicadoException ex, WebRequest request) {
        return construirResposta(HttpStatus.CONFLICT, "Recurso duplicado",
                "Já existe um registro com esses dados.");
    }

    @ExceptionHandler(RequisicaoInvalidaException.class)
    public ResponseEntity<ErroResponse> tratarRequisicaoInvalida(
            RequisicaoInvalidaException ex, WebRequest request) {
        return construirResposta(HttpStatus.BAD_REQUEST, "Requisição inválida",
                "Os dados enviados são inválidos.");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErroResponse> tratarErroGenerico(
            Exception ex, WebRequest request) {
        return construirResposta(HttpStatus.INTERNAL_SERVER_ERROR, "Erro interno no servidor",
                "Ocorreu um erro inesperado. Tente novamente mais tarde.");
    }

    private ResponseEntity<ErroResponse> construirResposta(
            HttpStatus status, String erro, String mensagem) {

        ErroResponse corpo = new ErroResponse(
                status.value(),
                erro,
                mensagem
        );
        return ResponseEntity.status(status).body(corpo);
    }
}
