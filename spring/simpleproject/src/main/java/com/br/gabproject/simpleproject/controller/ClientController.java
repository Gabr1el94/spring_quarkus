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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@Tag(name = "Client", description = "Tutorial management APIs")
@RestController
@RequestMapping("clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Operation(summary = "All Clients", description = "Get a Tutorial object by specifying all clients", tags = {
            "tutorials", "get", "list" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")
            })
    })
    @GetMapping("/")
    public ResponseEntity<List<Client>> listAll() {
        List<Client> clients = clientRepository.listAll();
        System.out.println(clients.size());
        return new ResponseEntity<>(clients, HttpStatus.ACCEPTED);
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

    @Operation(summary = "Find Client", description = "Get a Tutorial object by specifying find client by id", tags = {
            "tutorials", "get", "id" })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = Client.class), mediaType = "application/json")
            }),
            @ApiResponse(responseCode = "404", description = "Client not found by id", content = {
                    @Content(schema = @Schema()) }),
    })
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