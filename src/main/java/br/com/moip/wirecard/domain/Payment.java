package br.com.moip.wirecard.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double amount; //qtde
    private String type; //tipo de pagamento
    private Long boletoNumber;
    private String paymentStatus;

    @JsonIgnore
    @JoinColumn(name = "client_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Client client;

    @JsonIgnore
    @JoinColumn(name = "buyer_id")
    @ManyToOne(cascade = CascadeType.ALL)
    private Buyer buyer;

    @JsonIgnore
    @JoinColumn(name = "card_id")
    @ManyToOne
    private Card card;

    public Payment() {    }

    public Payment(double amount, String type, Long boletoNumber, String paymentStatus, Client client, Buyer buyer, Card card) {
        this.amount = amount;
        this.type = type;
        this.boletoNumber = boletoNumber;
        this.paymentStatus = paymentStatus;
        this.client = client;
        this.buyer = buyer;
        this.card = card;
    }

    public Long getId() {
        return id;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }
}
