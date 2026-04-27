package com.fag.lucasmartins.arquitetura_software.service;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoRequestDTO;
import com.fag.lucasmartins.arquitetura_software.dto.ProdutoResponseDTO;
import com.fag.lucasmartins.arquitetura_software.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponseDTO cadastrar(ProdutoRequestDTO request) {
        Produto produto = new Produto(
                request.getNome(),
                request.getEstoque(),
                request.getPreco()
        );

        produtoRepository.salvar(produto);

        return new ProdutoResponseDTO(
            "Produto cadastrado com sucesso!",
            produto.getNome(),
            produto.getEstoque(),
            produto.getPreco(),
            produto.getPrecoFinal()
        );
    }
}