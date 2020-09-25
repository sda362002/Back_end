package com.toyproj.pinchhitterhomerun.repository;

import com.toyproj.pinchhitterhomerun.model.PasswordHint;
import com.toyproj.pinchhitterhomerun.repository.interfaces.IPasswordHintRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PasswordHintRepository implements IPasswordHintRepository {

    private final EntityManager em;

    public PasswordHintRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public PasswordHint findById(Long id) {
        System.out.println(id);
        return em.find(PasswordHint.class, id);
    }

    @Override
    public PasswordHint findByText(String text) {
        return em.createQuery("select ph from PasswordHint ph where ph.text = :text", PasswordHint.class)
                .setParameter("text", text)
                .getSingleResult();
    }

    @Override
    public List<PasswordHint> findAll() {
        return em.createQuery("select ph from PasswordHint ph", PasswordHint.class)
                .getResultList();
    }
}
