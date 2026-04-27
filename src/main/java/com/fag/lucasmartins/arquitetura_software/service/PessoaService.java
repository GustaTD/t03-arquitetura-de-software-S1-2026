package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDTO;

public interface PessoaService {
    PessoaResponseDTO cadastrarPessoa(PessoaRequestDTO requestDTO);
}