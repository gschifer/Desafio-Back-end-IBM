package com.example.challenge.domain.exceptions.pautaExceptions;

import com.example.challenge.domain.exceptions.EntidadeNaoEncontradaException;

public class PautaNaoEncontradaException extends EntidadeNaoEncontradaException {
    private static final long serialVersionUID = 1L;

    public PautaNaoEncontradaException(String message) {
        super(message);
    }

    public PautaNaoEncontradaException(Long id) {
        this(String.format("A pauta de ID: %d, não existe no banco de dados.", id));
    }
}
