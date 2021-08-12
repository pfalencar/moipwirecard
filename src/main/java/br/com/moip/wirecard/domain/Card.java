package br.com.moip.wirecard.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "card")
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "holder_name")
    private String holderName; //nome do titular

    private int number;

    @Column(name = "expiration_date")
    private String expirationDate; //dt de validade

    private int cvv; //número atrás do cartão

    @OneToMany(mappedBy = "card")
    private List<Payment> payments = new ArrayList<>();

    public Card() {}

    public Card(String holderName, int number, String expirationDate, int cvv, List<Payment> payments) {
        this.holderName = holderName;
        this.number = number;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.payments = payments;
    }

    public Long getId() {
        return id;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", holderName='" + holderName + '\'' +
                ", number=" + number +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv=" + cvv +
                ", payments=" + payments +
                '}';
    }
}
