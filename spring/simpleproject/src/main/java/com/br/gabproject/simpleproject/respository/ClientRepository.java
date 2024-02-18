package com.br.gabproject.simpleproject.respository;

import java.util.List;

import com.br.gabproject.simpleproject.model.Client;

public interface ClientRepository {

    public List<Client> listAll();

    public Client findById(int id);

    public int addClient(Client client);

    public int updateClient(Client client, int id);

}
