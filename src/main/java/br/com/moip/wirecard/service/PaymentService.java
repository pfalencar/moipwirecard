package br.com.moip.wirecard.service;

import br.com.moip.wirecard.domain.Buyer;
import br.com.moip.wirecard.domain.Card;
import br.com.moip.wirecard.domain.Client;
import br.com.moip.wirecard.domain.Payment;
import br.com.moip.wirecard.dto.PaymentPostRequestBody;
import br.com.moip.wirecard.exception.BuyerNotFoundException;
import br.com.moip.wirecard.exception.CardNotFoundException;
import br.com.moip.wirecard.exception.ClientNotFoundException;
import br.com.moip.wirecard.repository.BuyerRepository;
import br.com.moip.wirecard.repository.CardRepository;
import br.com.moip.wirecard.repository.ClientRepository;
import br.com.moip.wirecard.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class PaymentService {
    private PaymentRepository paymentRepository;
    private BuyerRepository buyerRepository;
    private CardRepository cardRepository;
    private ClientRepository clientRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository, BuyerRepository buyerRepository,
                          CardRepository cardRepository, ClientRepository clientRepository) {
        this.paymentRepository = paymentRepository;
        this.buyerRepository = buyerRepository;
        this.cardRepository = cardRepository;
        this.clientRepository = clientRepository;
    }

    public Payment save(@org.jetbrains.annotations.NotNull PaymentPostRequestBody paymentPostRequestBody) throws
            BuyerNotFoundException, CardNotFoundException, ClientNotFoundException {

        Optional<Client> client = clientRepository.findById(paymentPostRequestBody.getClientId());
        if (client.isEmpty()) {
            throw new ClientNotFoundException();
        }

        Optional<Buyer> buyer = buyerRepository.findById(paymentPostRequestBody.getBuyerId());
        if (buyer.isEmpty()) {
            throw new BuyerNotFoundException();
        }

        if (!paymentPostRequestBody.getType().isEmpty() &&
                paymentPostRequestBody.getType().equalsIgnoreCase("boleto")) {
            return paymentRepository.save(build(paymentPostRequestBody, client.get(), buyer.get()));


        }
        Optional<Card> card = cardRepository.findById(paymentPostRequestBody.getCardId());
        if (card.isEmpty()) {
            throw new CardNotFoundException();
        }
        return paymentRepository.save(build(paymentPostRequestBody, client.get(), buyer.get(), card.get()));
    }

    public List<Payment> listAll() {
        return (List<Payment>) paymentRepository.findAll();
    }

    public Optional<Payment> findById(Long paymentId) {

        return paymentRepository.findById(paymentId);
    }

    //usado qdo o pagamento é por boleto
    public Payment build(PaymentPostRequestBody paymentPostRequestBody, Client client, Buyer buyer) {
        Payment payment = new Payment();
        payment.setAmount(paymentPostRequestBody.getAmount());
        payment.setType(paymentPostRequestBody.getType());
        payment.setBoletoNumber(Math.abs(new Random().nextLong()));
        payment.setPaymentStatus("Em espera");
        payment.setClient(client);
        payment.setBuyer(buyer);
        return payment;
    }

    //usado qdo o pagamento é com cartão
    public Payment build(PaymentPostRequestBody paymentPostRequestBody, Client client, Buyer buyer, Card card) {
        Payment payment = new Payment();
        payment.setAmount(paymentPostRequestBody.getAmount());
        payment.setType(paymentPostRequestBody.getType());
        payment.setPaymentStatus("Realizado");
        payment.setClient(client);
        payment.setBuyer(buyer);
        payment.setCard(card);
        return payment;
    }

}
