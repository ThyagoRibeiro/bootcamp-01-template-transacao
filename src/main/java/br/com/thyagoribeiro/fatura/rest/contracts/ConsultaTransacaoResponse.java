package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Transacao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ConsultaTransacaoResponse {

    private String id;

    @JsonProperty("data_efetivacao")
    private LocalDateTime dataEfetivacao;

    private BigDecimal valor;

    @JsonProperty("cartao")
    private ConsultaCartaoResponse consultaCartaoResponse;

    @JsonProperty("estabelecimento")
    private ConsultaEstabelecimentoResponse consultaEstabelecimentoResponse;

    @Deprecated
    public ConsultaTransacaoResponse() {
    }

    public ConsultaTransacaoResponse(Transacao transacao) {
        this.id = transacao.getId();
        this.dataEfetivacao = transacao.getEfetivadaEm();
        this.valor = new BigDecimal(transacao.getValor());
        this.consultaCartaoResponse = new ConsultaCartaoResponse(transacao.getCartao());
        this.consultaEstabelecimentoResponse = new ConsultaEstabelecimentoResponse(transacao.getEstabelecimento());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDataEfetivacao() {
        return dataEfetivacao;
    }

    public void setDataEfetivacao(LocalDateTime dataEfetivacao) {
        this.dataEfetivacao = dataEfetivacao;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public ConsultaCartaoResponse getConsultaCartaoResponse() {
        return consultaCartaoResponse;
    }

    public void setConsultaCartaoResponse(ConsultaCartaoResponse consultaCartaoResponse) {
        this.consultaCartaoResponse = consultaCartaoResponse;
    }

    public ConsultaEstabelecimentoResponse getConsultaEstabelecimentoResponse() {
        return consultaEstabelecimentoResponse;
    }

    public void setConsultaEstabelecimentoResponse(ConsultaEstabelecimentoResponse consultaEstabelecimentoResponse) {
        this.consultaEstabelecimentoResponse = consultaEstabelecimentoResponse;
    }
}
