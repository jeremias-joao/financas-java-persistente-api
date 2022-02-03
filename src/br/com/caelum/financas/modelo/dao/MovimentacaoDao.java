package br.com.caelum.financas.modelo.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class MovimentacaoDao {
    private EntityManager em;

    public MovimentacaoDao(EntityManager manager) {
        this.em = manager;
    }

    public List<Double> getMediasPorDiaETipo(TipoMovimentacao tipoMovimentacao, Conta conta) {

        String jpql = "select distinct avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo" +
                " group by m.data";

        TypedQuery<Double> query = em.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipoMovimentacao);

        return query.getResultList();

    }
}
