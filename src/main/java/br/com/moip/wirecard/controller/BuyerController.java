package br.com.moip.wirecard.controller;

import br.com.moip.wirecard.domain.Buyer;
import br.com.moip.wirecard.dto.BuyerPostRequestBody;
import br.com.moip.wirecard.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("buyers")
public class BuyerController {
    private BuyerService buyerService;

    @Autowired
    public BuyerController(BuyerService buyerService) { this.buyerService = buyerService; }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody BuyerPostRequestBody buyerPostRequestBody) {
        buyerService.save(buyerPostRequestBody);
        return new ResponseEntity<>("Buyer saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    public List<Buyer> listAll() {
        return buyerService.listAll();
    }
}
