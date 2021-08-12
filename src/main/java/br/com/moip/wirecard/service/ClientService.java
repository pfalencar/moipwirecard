package br.com.moip.wirecard.service;

import br.com.moip.wirecard.domain.Client;
import br.com.moip.wirecard.dto.ClientPostRequestBody;
import br.com.moip.wirecard.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository =  clientRepository;
    }

    public List<Client> listAll () {
        return (List<Client>) clientRepository.findAll();
    }

    public Client save(ClientPostRequestBody clientPostRequestBody) {
        return clientRepository.save(build(clientPostRequestBody));
    }

    private Client build(ClientPostRequestBody clientPostRequestBody) {
        Client client = new Client();
        client.setNome(clientPostRequestBody.getNome());
        return client;
    }

    public Optional<Client> findById(Long clientId) {
        return clientRepository.findById(clientId);
    }

}
