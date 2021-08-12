package br.com.moip.wirecard.dto;

import javax.validation.constraints.NotBlank;

public class ClientPostRequestBody {
    @NotBlank(message = "Nome é obrigatorio")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ClientPostRequestBody{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
