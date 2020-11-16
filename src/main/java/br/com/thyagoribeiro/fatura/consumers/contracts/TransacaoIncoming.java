package br.com.thyagoribeiro.fatura.consumers.contracts;

import br.com.thyagoribeiro.fatura.domains.Cartao;
import br.com.thyagoribeiro.fatura.domains.Estabelecimento;
import br.com.thyagoribeiro.fatura.domains.Transacao;
import br.com.thyagoribeiro.fatura.repositories.CartaoRepository;
import br.com.thyagoribeiro.fatura.repositories.EstabelecimentoRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

// CDD Total - 8

public class TransacaoIncoming {

    private String id;

    private String valor;

    @JsonProperty("estabelecimento")
    private EstabelecimentoIncoming estabelecimentoIncoming; // CDD 1 - Classe EstabelecimentoIncoming

    @JsonProperty("cartao")
    private CartaoIncoming cartaoIncoming; // CDD 1 - Classe CartaoIncoming

    private LocalDateTime efetivadaEm;

    @Deprecated
    public TransacaoIncoming() {
    }

    public TransacaoIncoming(String id, String valor, EstabelecimentoIncoming estabelecimentoIncoming, CartaoIncoming cartaoIncoming, LocalDateTime efetivadaEm) {
        this.id = id;
        this.valor = valor;
        this.estabelecimentoIncoming = estabelecimentoIncoming;
        this.cartaoIncoming = cartaoIncoming;
        this.efetivadaEm = efetivadaEm;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public EstabelecimentoIncoming getEstabelecimentoIncoming() {
        return estabelecimentoIncoming;
    }

    public void setEstabelecimentoIncoming(EstabelecimentoIncoming estabelecimentoIncoming) {
        this.estabelecimentoIncoming = estabelecimentoIncoming;
    }

    public CartaoIncoming getCartaoIncoming() {
        return cartaoIncoming;
    }

    public void setCartaoIncoming(CartaoIncoming cartaoIncoming) {
        this.cartaoIncoming = cartaoIncoming;
    }

    public LocalDateTime getEfetivadaEm() {
        return efetivadaEm;
    }

    public void setEfetivadaEm(LocalDateTime efetivadaEm) {
        this.efetivadaEm = efetivadaEm;
    }

    public Transacao toModel(CartaoRepository cartaoRepository, EstabelecimentoRepository estabelecimentoRepository) { // CDD 2 - Interfaces CartaoRepository e EstabelecimentoRepository

        Cartao cartao = cartaoRepository.findByNumeroCartao(cartaoIncoming.getId()); // CDD 1 - Classe Cartao
        if(cartao == null) // CDD 1 - branch if
            cartao = cartaoIncoming.toModel();

        Estabelecimento estabelecimento = estabelecimentoRepository.findByNomeAndCidadeAndEndereco( // CDD 1 - Classe Estabelecimento
                estabelecimentoIncoming.getNome(),
                estabelecimentoIncoming.getCidade(),
                estabelecimentoIncoming.getEndereco());
        if(estabelecimento == null) // CDD 1 - branch if
            estabelecimento = estabelecimentoIncoming.toModel();

        return new Transacao(id, valor, estabelecimento, cartao, efetivadaEm);
    }
}
