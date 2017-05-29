package spittr.data;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import spittr.model.Spitter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by drugo on 29/05/2017.
 */
@Repository
public class JpaSpitterRepository implements SpitterRepository{

    @PersistenceContext
    EntityManager em;

    public Spitter save(Spitter spitter) {
        em.persist(spitter);
        System.out.println("\nUtente salvato!");
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
