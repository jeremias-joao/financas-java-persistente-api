package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Cliente;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

import javax.persistence.EntityManager;

/**
 * Created by leonardocordeiro on 24/02/17.
 */
// TestaContaCliente.java

public class TestaContaCliente {

    public static void main(String[] args) {

        /*
           OBS: Não esqueça que será necessário deletar o banco e criar de novo
           para ver o @JoinColumn funcionando
        */

        Cliente cliente = new Cliente();
        cliente.setNome("Leonardo");
        cliente.setEndereco("Rua Fulano, 123");
        cliente.setProfissao("Professor");

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Douglas");
        cliente2.setEndereco("Rua Fulano, 234");
        cliente2.setProfissao("Professor");

        Conta conta = new Conta();
        conta.setId(2); // essa conta está no estado 'Detached' pois já possui um id!!

        cliente.setConta(conta);
        cliente2.setConta(conta);

        EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        em.persist(cliente);
//        em.persist(cliente2);

        em.getTransaction().commit();


    }
}