package br.com.moip.wirecard.exception;

public class PaymentNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Pagamento não encontrado!";
    }
}
