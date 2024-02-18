package com.br.gabproject.simpleproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.gabproject.simpleproject.model.Client;
import com.br.gabproject.simpleproject.model.domain.ClientBody;
import com.br.gabproject.simpleproject.respository.ClientRepository;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/")
    public ResponseEntity<?> listAll() {
        return new ResponseEntity<List<Client>>(clientRepository.listAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/")
    public ResponseEntity<?> addClient(@RequestBody ClientBody clientBody) {
        if (clientBody == null) {
            return new ResponseEntity<>("Preenchimento obrigatório", HttpStatus.PRECONDITION_FAILED);
        }
        Client client = new Client(clientBody.getName(), clientBody.getEmail());
        int result = clientRepository.addClient(client);
        if (result > 0) {
            return new ResponseEntity<>("Registro do cliente inserido com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Falha ao inserir os dados do cliente", HttpStatus.CONFLICT);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getbyID(@PathVariable int id) {
        Client client = clientRepository.findById(id);
        if (client == null) {
            return new ResponseEntity<>("Client not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(client, HttpStatus.ACCEPTED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatebyID(@RequestBody ClientBody clientBody, @PathVariable int id) {

        if (clientBody == null) {
            return new ResponseEntity<>("Preenchimento obrigatório", HttpStatus.PRECONDITION_FAILED);
        }

        Client findClient = clientRepository.findById(id);
        if (findClient == null) {
            return new ResponseEntity<>("Client " + id + " not found", HttpStatus.NOT_FOUND);
        }
        findClient.setName(clientBody.getName());
        findClient.setEmail(clientBody.getEmail());
        int result = clientRepository.updateClient(findClient, id);
        if (result > 0) {
            return new ResponseEntity<>("Cliente atualizado com sucesso", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Falha ao atualizar os dados do cliente", HttpStatus.CONFLICT);
    }

}