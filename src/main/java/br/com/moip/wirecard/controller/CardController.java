package br.com.moip.wirecard.controller;

import br.com.moip.wirecard.domain.Card;
import br.com.moip.wirecard.dto.CardPostRequestBody;
import br.com.moip.wirecard.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cards")
public class CardController {
    private CardService cardService;

    @Autowired
    public CardController(CardService cardService) { this.cardService = cardService; }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody CardPostRequestBody cardPostRequestBody){
        cardService.save(cardPostRequestBody);
        return new ResponseEntity<>("Card saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Card> listAll() {
        return cardService.listAll();
    }
}
