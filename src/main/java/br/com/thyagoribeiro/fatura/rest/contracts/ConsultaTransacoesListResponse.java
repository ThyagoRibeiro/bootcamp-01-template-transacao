package br.com.thyagoribeiro.fatura.rest.contracts;

import br.com.thyagoribeiro.fatura.domains.Transacao;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ConsultaTransacoesListResponse {

    @JsonProperty("transacoes")
    List<ConsultaTransacaoResponse> consultaTransacaoResponseList;

    public ConsultaTransacoesListResponse(List<Transacao> transacaoList) {
        consultaTransacaoResponseList = new ArrayList<>();
        if(transacaoList != null)
            transacaoList.forEach(transacao -> consultaTransacaoResponseList.add(new ConsultaTransacaoResponse(transacao)));
    }

    public List<ConsultaTransacaoResponse> getConsultaTransacaoResponseList() {
        return consultaTransacaoResponseList;
    }

    public void setConsultaTransacaoResponseList(List<ConsultaTransacaoResponse> consultaTransacaoResponseList) {
        this.consultaTransacaoResponseList = consultaTransacaoResponseList;
    }
}
