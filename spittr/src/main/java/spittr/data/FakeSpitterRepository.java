package spittr.data;

import org.springframework.stereotype.Component;
import spittr.domain.Spitter;

/**
 * Created by drugo on 19/05/2017.
 */
@Component
public class FakeSpitterRepository implements SpitterRepository {
    public Spitter save(Spitter spitter) {
        System.out.println("Salvataggio utente!");
        return null;
    }

    public Spitter findByUsername(String username) {
        return new Spitter(24L, "jbauer", "24hours", "Jack", "Bauer");
    }
}
