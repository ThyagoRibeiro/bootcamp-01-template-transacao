package br.com.thyagoribeiro.fatura.consumers.contracts;

import br.com.thyagoribeiro.fatura.domains.Estabelecimento;

// CDD Total - 1

public class EstabelecimentoIncoming {

    private String nome;

    private String cidade;

    private String endereco;

    @Deprecated
    public EstabelecimentoIncoming() {
    }

    public EstabelecimentoIncoming(String nome, String cidade, String endereco) {
        this.nome = nome;
        this.cidade = cidade;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Estabelecimento toModel() { // CDD 1 - Classe Estabelecimento
        return new Estabelecimento(nome, cidade, endereco);
    }

}
