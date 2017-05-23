package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import spittr.Spittle;
import spittr.data.SpittleRepository;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by drugo on 18/05/2017.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {
    private static final String MAX_LONG_AS_STRING = "9223372036854775807";

    private SpittleRepository spittleRepository;

    @Autowired
    public SpittleController(@Qualifier("jdbcSpittleRepository") SpittleRepository spittleRepository) {
        this.spittleRepository = spittleRepository;
    }

    /*
        Gestisce tutte le richieste che arrivano senza parametri
    */
    /*
    Notice that the spittles() method is given a Model as a parameter. This is so that
    spittles() can populate the model with the Spittle list it retrieves from the repository.
    The Model is essentially a map (that is, a collection of key-value pairs).
    The last thing spittles() does is return "spittles" as the name of the view that will
    render the model.
     */
     @RequestMapping(method= RequestMethod.GET)
     public String spittles(Map model) {
        // In fase di testing stampe in console i 20 spittles più recenti!
        System.out.println("\nTEST relativo al recupero dei 20 spittles più recenti");
        for (Spittle spit: spittleRepository.findRecentSpittles()) {
            System.out.println("\nMessage: \n"+spit.getMessage());
        }

        /*
            A list of Spittle objects is stored in the model with a key of spittleList
            and given to the view whose name is spittles. Given the way you’ve configured
            InternalResourceViewResolver, that view is a JSP at /WEB-INF/views/spittles.jsp.
         */
        model.put("spittleList",spittleRepository.findRecentSpittles());
        return "spittles";
    }

    /*
    Da notare come in questo caso viene utilizzata l'apposita classe SpittleForm per immagazzinare i valori che arrivano dal form che l'utente ha popolato relativo all'inserimento dello Spittle.
    Da questa istanza di SpittleForm si và a creare e salvare l'oggetto Spittle vero e proprio.
    */
    @RequestMapping(method=RequestMethod.POST)
    public String processInsertSplittle(SpittleForm form) throws Exception {
         spittleRepository.save(new Spittle(null, form.getMessage(),new Date(), form.getLatitude(), form.getLongitude()));
         return "home";
    }

    /*
        Ritorna una lista di Spittles a partire da quello che presenta ID=max (1° parametro della richiesta) a ritroso andandone a prelevare "count" (2° parametro della richiesta).
        Da notare in questo caso la richiesta dei Query parameters "max" e "count" per mappare oppurtanamente la richiesta GET che arriva
    */
    /*
        Now, if the max parameter isn’t specified, it will default to the maximum value of Long.
        Because query parameters are always of type String, the defaultValue attribute requires a String value.
        Even though the defaultValue is given as a String, it will be converted to a Long
        when bound to the method’s max parameter
    */
    @RequestMapping(method=RequestMethod.GET, params = {"max","count"})
    public String spittles(@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, @RequestParam(value="count", defaultValue="20") int count, Map model) {
        System.out.println("\nTEST relativo al recupero dei successi 'count' spittles che seguono quello con ID='max'");
        for (Spittle spit: spittleRepository.findRecentSpittles()) {
            System.out.println("\nMessage: \n"+spit.getMessage());
        }

        model.put("spittleList",spittleRepository.findSpittles(max, count));
        return "spittles";
    }

    /*
    * Esempio di gestione degli input utente attraverso paramteri passati via PATH anzichè parametri di query
    * Viene richiesto il recuepero di un preciso spittle con dato ID*/
    @RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
    public String spittle(@PathVariable("spittleId") long spittleId, Map model) {
        System.out.println("\nTEST relativo al recupero di un preciso splittle con dato ID");

        model.put("spittle",spittleRepository.findOne(spittleId));
        return "spittle";
    }
}
