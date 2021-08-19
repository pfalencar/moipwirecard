package br.com.moip.wirecard.dto;

import br.com.moip.wirecard.domain.Buyer;
import br.com.moip.wirecard.domain.Card;
import br.com.moip.wirecard.domain.Client;

public class PaymentResponseBody {

    private Long id;
    private double amount; //qtde
    private String type; //tipo de pagamento
    private Long boletoNumber;
    private String paymentStatus;

    private Long clientId;
    private Long buyerId;
    private Long cardId;

    public PaymentResponseBody(Long id, double amount, String type, Long boletoNumber, String paymentStatus,
                               Client client, Buyer buyer, Card card) {
        this.id = id;
        this.amount = amount;
        this.type = type;
        this.boletoNumber = boletoNumber;
        this.paymentStatus = paymentStatus;
        this.clientId = client.getId();
        this.buyerId = buyer.getId();
        this.cardId = card.getId();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getBoletoNumber() {
        return boletoNumber;
    }

    public void setBoletoNumber(Long boletoNumber) {
        this.boletoNumber = boletoNumber;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }
}
