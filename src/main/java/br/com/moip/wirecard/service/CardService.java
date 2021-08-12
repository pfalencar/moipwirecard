package br.com.moip.wirecard.service;

import br.com.moip.wirecard.domain.Card;
import br.com.moip.wirecard.dto.CardPostRequestBody;
import br.com.moip.wirecard.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardService {
    private CardRepository cardRepository;

    @Autowired
    public CardService(CardRepository cardRepository){ this.cardRepository = cardRepository; }

    public Card save(CardPostRequestBody cardPostRequestBody) {
        return cardRepository.save(build(cardPostRequestBody));
    }

    private Card build(CardPostRequestBody cardPostRequestBody) {
        Card card = new Card();
        card.setHolderName(cardPostRequestBody.getHolderName());
        card.setNumber(cardPostRequestBody.getNumber());
        card.setExpirationDate(cardPostRequestBody.getExpirationDate());
        card.setCvv(cardPostRequestBody.getCvv());
        return card;
    }

    public List<Card> listAll() {
        return (List<Card>)cardRepository.findAll();
    }
}
