package br.com.thyagoribeiro.fatura.consumers;

import br.com.thyagoribeiro.fatura.consumers.contracts.TransacaoIncoming;
import br.com.thyagoribeiro.fatura.domains.Transacao;
import br.com.thyagoribeiro.fatura.repositories.CartaoRepository;
import br.com.thyagoribeiro.fatura.repositories.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

// CDD Total - 4

@Component
public class TransacaoConsumer {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private CartaoRepository cartaoRepository; // CDD 1 - Interface CartaoRepository

    @Autowired
    private EstabelecimentoRepository estabelecimentoRepository; // CDD 1 - Interface EstabelecimentoRepository

    @KafkaListener(topics = "${spring.kafka.topic.transactions}")
    @Transactional
    public void ouvir(TransacaoIncoming transacaoIncoming) { // CDD 1 - Classe TransacaoIncoming
        Transacao transacao = transacaoIncoming.toModel(cartaoRepository, estabelecimentoRepository); // CDD 1 - Classe Transacao
        entityManager.persist(transacao);
    }

}
