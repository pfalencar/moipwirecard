package br.com.moip.wirecard.exception;

public class BuyerNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Comprador não encontrado!";
    }
}
