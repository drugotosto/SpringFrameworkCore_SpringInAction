package spittr.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

/**
 * Created by drugo on 22/05/2017.
 */
@Configuration
public class DataConfig {

    /*
    Regardless of which form of Spring-supported data access you use,
    you’ll likely need to configure a reference to a data source.
    In questo caso ho scelto di utilizzare un data source definito tramite JDBC Driver.
    For production-ready applications, I recommend using a data source that draws its
    connections from a connection pool. When possible, I prefer to retrieve the pooled
    data source from an application server via JNDI.
     */
    @Bean
    public DataSource dataSource() {
        /*
        The simplest data source you can configure in Spring is one that’s defined through a JDBC driver.
        Spring offers three such data-source classes to choose from:
        - DriverManagerDataSource: ritorna una nuova connessione ogni volta che ne viene richiesta una
        - SimpleDriverDataSource: Simile a quella di prima.
        - SingleConnectionDataSource: Ritorna la stessa connessione ogni volta che ne viene richiesta una. Non funziona bene in situazioni di multithreading
        */
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spittrdb");
        ds.setUsername("drugo");
        ds.setPassword("Juventus84");
        return ds;
    }

    /*
    Creazione del data-access template bean utilizzato dalla classe JdbcSpittleRepository di tipo "jdbcTemplate".
    JdbcTemplate: The most basic of Spring’s JDBC templates, this class provides simple access to a database through JDBC and indexed-parameter queries.
    */
    @Bean
    public JdbcOperations jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /*
    Creazione del data-access template bean utilizzato dalla classe JdbcSpitterRepository di tipo "NamedParameterJdbcTemplate"
    NamedParameterJdbcTemplate: This JDBC template class enables you to perform
    queries where values are bound to named parameters in SQL, rather than indexed parameters
    */
    @Bean
    public NamedParameterJdbcTemplate jdbcNamedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);
    }
}
