package br.com.moip.wirecard.dto;

import br.com.moip.wirecard.domain.Payment;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class CardPostRequestBody {

    @NotBlank(message = "Nome do titular é obrigatorio")
    private String holderName;

    @NotNull(message = "Número do cartão é obrigatório")
    private int number;

    @NotBlank(message = "Data de validade é obrigatoria")
    private String expirationDate;

    @NotNull(message = "cvv é obrigatório")
    private int cvv;

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

    @Override
    public String toString() {
        return "CardPostRequestBody{" +
                "holderName='" + holderName + '\'' +
                ", number=" + number +
                ", expirationDate='" + expirationDate + '\'' +
                ", cvv=" + cvv +
                '}';
    }
}
