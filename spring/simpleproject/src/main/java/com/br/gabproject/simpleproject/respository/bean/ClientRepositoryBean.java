package com.br.gabproject.simpleproject.respository.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.br.gabproject.simpleproject.model.Client;
import com.br.gabproject.simpleproject.model.mapper.ClientMapper;
import com.br.gabproject.simpleproject.respository.ClientRepository;

@Repository
public class ClientRepositoryBean implements ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Client> listAll() {
        return this.jdbcTemplate.query("SELECT * FROM CLIENT", new ClientMapper());
    }

    @Override
    public Client findById(int id) {
        List<Client> client = jdbcTemplate.query("SELECT * FROM CLIENT WHERE IDPESSOA = ?",
                new ClientMapper(), id);
        if (client.isEmpty()) {
            return null;
        }
        return client.get(0);
    }

    @Override
    public int addClient(Client client) {
        return jdbcTemplate.update("INSERT INTO CLIENT(NAME, EMAIL, PASSWORD, ROLE) VALUES (?, ?, ?, ?)",
                client.getName(),
                client.getEmail(),
                client.getPassword(),
                client.getRole());
    }

    @Override
    public int updateClient(Client client, int id) {
        return jdbcTemplate.update("UPDATE CLIENT SET NAME = ?, EMAIL = ? , ROLE = ? WHERE IDPESSOA = ?",
                client.getName(),
                client.getEmail(),
                client.getRole(),
                client.getIdPessoa());
    }

}
