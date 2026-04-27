package com.fag.lucasmartins.arquitetura_software.dto;

public class ProdutoResponseDTO {

    private String mensagem;
    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public ProdutoResponseDTO() {
    }

    public ProdutoResponseDTO(String mensagem, String nome, Integer estoque, Double preco, Double precoFinal) {
        this.mensagem = mensagem;
        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = precoFinal;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
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

    public Double getPrecoFinal() {
        return precoFinal;
    }

    public void setPrecoFinal(Double precoFinal) {
        this.precoFinal = precoFinal;
    }
}