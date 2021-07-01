package br.com.zupacademy.juliana.proposta.criacaoproposta;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Component
public class ExecutorTransacao {

    @PersistenceContext
    private EntityManager manager;

    @Transactional
    public <T> T saveAndCommit(T object) {
        manager.persist(object);
        return object;
    }

    @Transactional
    public <T> T updateAndCommit(T object) {
        return manager.merge(object);
    }

}

