package com.fag.lucasmartins.arquitetura_software.repository;

import com.fag.lucasmartins.arquitetura_software.domain.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcPessoaRepository implements PessoaRepository {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPessoaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void salvar(Pessoa pessoa) {
        String sql = "INSERT INTO pessoa (id, nome_completo, cpf, data_nascimento, email, telefone) VALUES (?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(
                sql,
                pessoa.getId().toString(),
                pessoa.getNomeCompleto(),
                pessoa.getCpf(),
                pessoa.getDataNascimento(),
                pessoa.getEmail(),
                pessoa.getTelefone()
        );
    }
}