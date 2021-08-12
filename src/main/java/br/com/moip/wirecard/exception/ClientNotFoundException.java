package br.com.moip.wirecard.exception;

public class ClientNotFoundException extends Exception {

    @Override
    public String getMessage() {
        return "Cliente não encontrado!";
    }
}
