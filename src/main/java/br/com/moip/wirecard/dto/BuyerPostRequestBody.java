package br.com.moip.wirecard.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class BuyerPostRequestBody {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    @Email(message = "É obrigatório ser um e-mail.")
    private String email;
    @NotBlank(message = "CPF é obrigatório")
    private String cpf;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "buyerPostRequestBody{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
