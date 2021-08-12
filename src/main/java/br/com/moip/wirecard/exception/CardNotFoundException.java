package br.com.moip.wirecard.exception;

public class CardNotFoundException extends Exception {
    @Override
    public String getMessage() {
        return "Cartão não encontrado!";
    }
}
