package br.com.thyagoribeiro.fatura.repositories;

import br.com.thyagoribeiro.fatura.domains.Estabelecimento;
import br.com.thyagoribeiro.fatura.domains.Transacao;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EstabelecimentoRepository extends CrudRepository<Estabelecimento, String> {

    Estabelecimento findByNomeAndCidadeAndEndereco(String nome, String cidade, String endereco);

}
