<h4>Sviluppo della microblogging application "Spittr" (stile Twitter) tramite utilizzo di SpringMVC.</h4>

<p> Esempio preso dal libro Spring in Action</p>

<div><h5>Gli elementi principali sono:</h5>
<ul>
    <li><b>spitters:</b> Gli utenti dell'applicazione
    <li><b>spittles:</b> Gli aggiornamenti di stato degli utenti
</ul>
</div>

<div>
<h5>Il progetto è stato diviso in diverse parti:</h5>
<ul>
    <li>
        Gestione delle richieste HTTP GET (con e senza parametri utente) e POST (form).
        <br>In particolare per quanto riguarda le richieste HTTP GET la gestione dei parametri è stata divisa in:
        <ul>
            <li>Query parameters</li>
            <li>Path variables</li>
            <li>Form parameters</li>
        </ul>
    </li>
    <li>
       Utilizzo di Apache Tiles come gestore del layout
    </li>
    <li>
        Sviluppo componenti DAO (Repository) per gestione della persistenza dei dati utilizzando DBMS MySql.
        I componenti @Repository così creati (JdbcSpitterRepository, JdbcSpittleRepository) utilizzano il driver JDBC e quindi interrogazioni SQL.
    </li>
    
</ul>
</div>
