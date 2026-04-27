package com.fag.lucasmartins.arquitetura_software.controller;

import com.fag.lucasmartins.arquitetura_software.dto.PessoaRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.PessoaResponseDTO;
import com.fag.lucasmartins.arquitetura_software.service.PessoaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<PessoaResponseDTO> cadastrarPessoa(@RequestBody PessoaRequestDTO requestDTO) {
        PessoaResponseDTO responseDTO = pessoaService.cadastrarPessoa(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}