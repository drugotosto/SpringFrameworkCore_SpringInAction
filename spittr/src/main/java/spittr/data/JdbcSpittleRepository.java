package spittr.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import spittr.Spitter;
import spittr.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by drugo on 23/05/2017.
 */
@Repository
public class JdbcSpittleRepository implements SpittleRepository {

    private JdbcOperations jdbcOperations;

    private static final String SELECT_SPITTLE = "select id, message, time, latitude, longitude from Spittle ";

    /*
    By injecting a JdbcOperations instead of the concrete JdbcTemplate, JdbcSpittleRepository
    is able to remain loosely coupled to JdbcTemplate via the JdbcOperations interface.
     */
    @Autowired
    public JdbcSpittleRepository(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    public List<Spittle> findRecentSpittles() {
        return findRecent(10);
    }

    public List<Spittle> findRecent(int count) {
        /*
        For every row that results from the query, JdbcTemplate calls the mapRow() method of the RowMapper,
        passing in a ResultSet and an integer carrying the row number.
        In SpitterRowMapper’s mapRow() method is the code that creates a
        Spitter object and populates it with values from the ResultSet.
        */
        String select_recent_splittle  = SELECT_SPITTLE + "order by time desc limit ?";
        return jdbcOperations.query(select_recent_splittle, new SpittleRowMapper(), count);
    }

    /*
    The real magic happens in the SpitterRowMapper object, which implements the RowMapper interface.
    For every row that results from the query, JdbcTemplate calls the mapRow() method of the RowMapper,
    passing in a ResultSet and an integer carrying the row number.
    In SpitterRowMapper’s mapRow() method is the code that creates a Spitter object and populates it
    with values from the ResultSet.
     */
    private static final class SpittleRowMapper implements RowMapper<Spittle> {
        public Spittle mapRow(ResultSet rs, int rowNum) throws SQLException {
            long id = rs.getLong("id");
            String message = rs.getString("message");
            Date time = rs.getTimestamp("time");
            Double longitude = rs.getDouble("longitude");
            Double latitude = rs.getDouble("latitude");
            return new Spittle(id, message, time, latitude, longitude);
        }
    }

    public List<Spittle> findSpittles(long max, int count) {
        return null;
    }

    public Spittle findOne(long id) {
        return null;
    }

    public void save(Spittle spittle) {
        String insert_spittle= "insert into Spittle (message, time , latitude, longitude) values (?, ?, ?, ?)";
        jdbcOperations.update( insert_spittle,
                spittle.getMessage(),
                spittle.getTime(),
                spittle.getLatitude(),
                spittle.getLongitude());
    }
}
