package br.com.moip.wirecard.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentPostRequestBody {

    @NotNull(message = "Quantidade é obrigatória")
    private double amount;
    @NotBlank(message = "Tipo é obrigatório")
    private String type;
    private Long clientId;
    private Long buyerId;
    private Long cardId;

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

    @Override
    public String toString() {
        return "PaymentPostRequestBody{" +
                "amount=" + amount +
                ", type='" + type + '\'' +
                ", clientId=" + clientId +
                ", buyerId=" + buyerId +
                ", cardId=" + cardId +
                '}';
    }
}
