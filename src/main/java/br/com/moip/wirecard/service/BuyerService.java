package br.com.moip.wirecard.service;

import br.com.moip.wirecard.domain.Buyer;
import br.com.moip.wirecard.dto.BuyerPostRequestBody;
import br.com.moip.wirecard.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerService {
    private BuyerRepository buyerRepository;

    @Autowired
    public BuyerService(BuyerRepository buyerRepository) {
        this.buyerRepository = buyerRepository;
    }

    public Buyer save(BuyerPostRequestBody buyerPostRequestBody) {
        return buyerRepository.save(build(buyerPostRequestBody));
    }

    public List<Buyer> listAll() {
        return (List<Buyer>)buyerRepository.findAll();
    }

    public Buyer build(BuyerPostRequestBody buyerPostRequestBody) {
        Buyer buyer = new Buyer();
        buyer.setNome(buyerPostRequestBody.getNome());
        buyer.setEmail(buyerPostRequestBody.getEmail());
        buyer.setCpf(buyerPostRequestBody.getCpf());
        return buyer;
    }
}
