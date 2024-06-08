package com.br.gabproject.simpleproject.respository.bean;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.br.gabproject.simpleproject.model.Client;
import com.br.gabproject.simpleproject.model.mapper.ClientMapper;
import com.br.gabproject.simpleproject.respository.AuthRepository;

@Repository
public class AuthRepositoryBean implements AuthRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Client findClientUsernameAndPass(String username) {
        List<Client> client = jdbcTemplate.query("SELECT * FROM CLIENT WHERE EMAIL = ?",
                new ClientMapper(), username);
        if (client.isEmpty()) {
            return null;
        }
        return client.get(0);
    }

}
