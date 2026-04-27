package com.fag.lucasmartins.arquitetura_software.domain;

import com.fag.lucasmartins.arquitetura_software.exceptions.DomainException;

import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class Pessoa {

    private UUID id;
    private String nomeCompleto;
    private String cpf;
    private LocalDate dataNascimento;
    private String email;
    private String telefone;

    public Pessoa(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        validar(nomeCompleto, cpf, dataNascimento, email, telefone);

        this.id = UUID.randomUUID();
        this.nomeCompleto = nomeCompleto;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.email = email;
        this.telefone = telefone;
    }

    private void validar(String nomeCompleto, String cpf, LocalDate dataNascimento, String email, String telefone) {
        if (nomeCompleto == null || nomeCompleto.isEmpty()) {
            throw new DomainException("Nome completo é obrigatório");
        }

        if (cpf == null || cpf.isEmpty()) {
            throw new DomainException("CPF é obrigatório");
        }

        if (cpf.length() != 11) {
            throw new DomainException("CPF deve possuir 11 caracteres");
        }

        if (telefone == null || telefone.isEmpty()) {
            throw new DomainException("Telefone é obrigatório");
        }

        if (telefone.length() != 11) {
            throw new DomainException("Telefone deve possuir 11 caracteres");
        }

        if (email == null || email.isEmpty()) {
            throw new DomainException("E-mail é obrigatório");
        }

        if (!email.contains("@")) {
            throw new DomainException("E-mail inválido");
        }

        if (dataNascimento == null) {
            throw new DomainException("Data de nascimento é obrigatória");
        }

        int idade = Period.between(dataNascimento, LocalDate.now()).getYears();
        if (idade < 18) {
            throw new DomainException("A pessoa deve ser maior de idade");
        }
    }

    public UUID getId() {
        return id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }
}