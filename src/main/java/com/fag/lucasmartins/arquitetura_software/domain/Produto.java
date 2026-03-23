package com.fag.lucasmartins.arquitetura_software.domain;

public class Produto {

    private String nome;
    private Integer estoque;
    private Double preco;
    private Double precoFinal;

    public Produto(String nome, Integer estoque, Double preco) {
        validar(nome, estoque, preco);

        this.nome = nome;
        this.estoque = estoque;
        this.preco = preco;
        this.precoFinal = calcularPrecoFinal();
    }

    private void validar(String nome, Integer estoque, Double preco) {
        if (nome == null || nome.isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio");
        }

        if (preco == null || preco <= 0) {
            throw new IllegalArgumentException("Preço deve ser maior que zero");
        }

        if (estoque == null || estoque < 0) {
            throw new IllegalArgumentException("Estoque inválido");
        }

        // REGRA PREMIUM (tiramos do controller)
        if (nome.toLowerCase().contains("premium") && preco < 100.0) {
            throw new IllegalArgumentException("Produtos Premium não podem custar menos de R$ 100,00.");
        }
    }

    private Double calcularPrecoFinal() {
        // REGRA DE ATACADO (tiramos do controller)
        if (estoque >= 50) {
            return preco - (preco * 0.10);
        }
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public Double getPreco() {
        return preco;
    }

    public Double getPrecoFinal() {
        return precoFinal;
    }
}