package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.domain.Pessoa;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDTO;
import com.fag.lucasmartins.arquitetura_software.repository.PessoaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaServiceImpl implements PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaServiceImpl(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    @Override
    public PessoaResponseDTO cadastrarPessoa(PessoaRequestDTO requestDTO) {
        Pessoa pessoa = new Pessoa(
                requestDTO.getNomeCompleto(),
                requestDTO.getCpf(),
                LocalDate.parse(requestDTO.getDataNascimento()),
                requestDTO.getEmail(),
                requestDTO.getTelefone()
        );

        pessoaRepository.salvar(pessoa);

        return new PessoaResponseDTO(
                pessoa.getId(),
                pessoa.getNomeCompleto(),
                pessoa.getCpf(),
                pessoa.getDataNascimento().toString(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }
}