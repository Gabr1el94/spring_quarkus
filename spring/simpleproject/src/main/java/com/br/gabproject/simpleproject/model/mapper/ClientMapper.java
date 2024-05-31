package com.br.gabproject.simpleproject.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.br.gabproject.simpleproject.model.Client;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int rowNum) throws SQLException {
        Client client = new Client();
        client.setIdPessoa(rs.getInt("idpessoa"));
        client.setName(rs.getString("name"));
        client.setEmail(rs.getString("email"));
        client.setRole(rs.getString("role"));
        return client;
    }

}
