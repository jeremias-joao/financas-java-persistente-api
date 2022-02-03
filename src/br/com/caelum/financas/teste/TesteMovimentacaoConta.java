package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();
        Query query = manager.createQuery("select distinct c from Conta c left join fetch c.movimentacoes");

        List<Conta> contas = query.getResultList();

        for (Conta conta : contas) {
            System.out.println("Titular: " + conta.getTitular());
            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
        }
    }


}
