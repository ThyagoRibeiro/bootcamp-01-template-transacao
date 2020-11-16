package br.com.thyagoribeiro.fatura.rest;

import br.com.thyagoribeiro.fatura.domains.Transacao;
import br.com.thyagoribeiro.fatura.handler.ErroPadronizado;
import br.com.thyagoribeiro.fatura.rest.contracts.ConsultaTransacoesListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

// CDD Total - 3

@RestController
public class ConsultaTransacoesController {

    @PersistenceContext
    private EntityManager entityManager;

    @GetMapping("/api/cartoes/{id_cartao}")
    public ResponseEntity<?> consultaTransacoes(
            @PathVariable("id_cartao") String cartaoId) {

        Query query = entityManager.createQuery("SELECT t FROM Transacao t WHERE t.cartao.id = :cartaoId ORDER BY t.efetivadaEm DESC");
        query.setParameter("cartaoId", cartaoId);
        query.setMaxResults(10);

        List<Transacao> transacaoList = query.getResultList(); // CDD 1 - Classe Transacao

        if(transacaoList.isEmpty()) // CDD 1 - branch if
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ErroPadronizado("Não existem transações para esse cartão"));

        ConsultaTransacoesListResponse consultaTransacoesListResponse = new ConsultaTransacoesListResponse(transacaoList); // CDD 1 - Classe ConsultaTransacoesListResponse

        return ResponseEntity.ok(consultaTransacoesListResponse);
    }

}
