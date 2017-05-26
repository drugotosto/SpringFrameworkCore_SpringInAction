package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import spittr.model.Spitter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by drugo on 23/05/2017.
 */
@Repository
public class JdbcSpitterRepository implements SpitterRepository {

    private NamedParameterJdbcTemplate  jdbcOperations;

    @Autowired
    public JdbcSpitterRepository(NamedParameterJdbcTemplate jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    /*
    Da notare come in questo caso avendo usato il NamedParameterJdbcTemplate ad ogni parametro in SQL
    viene attribuito un nome esplicito a cui ci si riferisce quando si va a fare l'associazione dei valori tramite Map.
    */
    public Spitter save(Spitter spitter) {
        /*
        Just because you don’t see a lot of boilerplate code doesn’t mean it’s not there.
        It’s cleverly hidden in the JDBC template class.
        When the update() method is called, jdbcOperations gets a connection,
        creates a statement, and executes the insert SQL
        */
        String insert_spitter= "insert into spitter (username, password, firstName, lastName, email) values (:username, :password, :firstName, :lastName, :email)";
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("username", spitter.getUsername());
        paramMap.put("firstName", spitter.getFirstName());
        paramMap.put("password", spitter.getPassword());
        paramMap.put("lastName", spitter.getLastName());
        paramMap.put("email", spitter.getEmail());
        jdbcOperations.update(insert_spitter, paramMap);
        return spitter;
    }

    public Spitter findByUsername(String username) {
        return null;
    }
}
