package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.domain.Produto;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcProdutoRepository implements ProdutoRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcProdutoRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvar(Produto produto) {
        String sql = "INSERT INTO produto (nome, preco, preco_final, estoque) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update(
                sql,
                produto.getNome(),
                produto.getPreco(),
                produto.getPrecoFinal(),
                produto.getEstoque()
        );
    }
}