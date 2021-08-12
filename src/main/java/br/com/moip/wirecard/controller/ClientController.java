package br.com.moip.wirecard.controller;

import br.com.moip.wirecard.domain.Client;
import br.com.moip.wirecard.dto.ClientPostRequestBody;
import br.com.moip.wirecard.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    private ClientService clientService;

    @Autowired
    public ClientController (ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody ClientPostRequestBody clientPostRequestBody) {
        clientService.save(clientPostRequestBody);
        return new ResponseEntity<>("Client saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Client> listAll() {
        return clientService.listAll();
    }
}
