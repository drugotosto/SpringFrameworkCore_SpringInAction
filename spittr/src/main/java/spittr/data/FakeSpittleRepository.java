package spittr.data;

import org.springframework.stereotype.Component;
import spittr.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by drugo on 18/05/2017.
 */

@Component
/*Classe fittizia che implementa il repository (quella reale darà la possibilità di effettuare delle richieste al DB)*/
public class FakeSpittleRepository implements SpittleRepository {

    public List<Spittle> findRecentSpittles() {
        int count=20;
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    public List<Spittle> findSpittles(long max, int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();
        for (int i=0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    public Spittle findOne(long id) {
        return null;
    }

}
