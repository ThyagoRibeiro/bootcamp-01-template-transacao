package br.com.thyagoribeiro.fatura.consumers.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;

// CDD Total - 1

public class CartaoIncoming {

    private String id;

    private String email;

    @Deprecated
    public CartaoIncoming() {
    }

    public CartaoIncoming(String id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cartao toModel() { // CDD 1 - Classe Cartao
        return new Cartao(id, email);
    }

}
