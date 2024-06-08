package com.br.gabproject.simpleproject.respository;

import com.br.gabproject.simpleproject.model.Client;

public interface AuthRepository {

    public Client findClientUsernameAndPass(String username);

}
