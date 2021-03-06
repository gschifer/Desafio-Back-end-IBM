package com.example.challenge.domain.exceptions.votoExceptions;

import com.example.challenge.domain.exceptions.EntidadeNaoEncontradaException;

public class VotoNaoEncontradoException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public VotoNaoEncontradoException(String message) {
        super(message);
    }

    public VotoNaoEncontradoException(Long id) {
        this(String.format("O voto de ID: %d, não existe no banco de dados.", id));
    }
}
