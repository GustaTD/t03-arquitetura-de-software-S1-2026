package com.fag.lucasmartins.arquitetura_software.exceptions;

public class DomainException extends RuntimeException {

    public DomainException(String mensagem) {
        super(mensagem);
    }
}