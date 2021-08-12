package br.com.moip.wirecard.controller;

import br.com.moip.wirecard.domain.Payment;
import br.com.moip.wirecard.dto.PaymentPostRequestBody;
import br.com.moip.wirecard.exception.BuyerNotFoundException;
import br.com.moip.wirecard.exception.CardNotFoundException;
import br.com.moip.wirecard.exception.ClientNotFoundException;
import br.com.moip.wirecard.exception.PaymentNotFoundException;
import br.com.moip.wirecard.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("payments")
public class PaymentController {
    private PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) { this.paymentService = paymentService; }

    @PostMapping
    public ResponseEntity<String> save(@RequestBody PaymentPostRequestBody paymentPostRequestBody) throws
            BuyerNotFoundException, CardNotFoundException, ClientNotFoundException {
        Payment p = paymentService.save(paymentPostRequestBody);
        if (paymentPostRequestBody.getType().equalsIgnoreCase("boleto")) {
            return new ResponseEntity<>("Payment saved successful!" +
                    "\nBoleto's Number: " + p.getBoletoNumber(), HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Payment with card was successful!", HttpStatus.CREATED);
    }

    @GetMapping
    @RequestMapping("/{paymentId}")
    public Payment findById(@PathVariable Long paymentId) throws PaymentNotFoundException{
        Optional<Payment> paymentOptional = paymentService.findById(paymentId);
        Payment payment = paymentOptional.orElseThrow(() -> new PaymentNotFoundException());
        return payment;
    }

    @GetMapping
    public List<Payment> listAll() {
        return paymentService.listAll();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = {PaymentNotFoundException.class})
    public String handleNotFoundExceptions(Exception e) {
        return e.getMessage();
    }
}
