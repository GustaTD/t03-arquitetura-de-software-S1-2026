package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoRequestDTO {

    private String nome;
    private Integer estoque;
    private Double preco;

    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String nome, Integer estoque, Double preco) {
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}