package spittr.data;

import spittr.model.Spitter;

/**
 * Created by drugo on 19/05/2017.
 */
public interface SpitterRepository {

    Spitter save(Spitter spitter);

    Spitter findByUsername(String username);

}
