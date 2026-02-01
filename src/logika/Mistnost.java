package logika;

import java.util.HashMap;
import java.util.Map;

public class Mistnost {
    private String nazev;
    private String popis;
    private Map<String, Mistnost> vychody;

    public Mistnost(String nazev, String popis) {
        this.nazev = nazev;
        this.popis = popis;
        this.vychody = new HashMap<>();
    }

    public void setVychod(String smer, Mistnost vedlejsi) {
        vychody.put(smer, vedlejsi);
    }

    public Mistnost vratVychod(String smer) {
        return vychody.get(smer);
    }

    public String getNazev() {
        return nazev;
    }

    public String dlouhyPopis() {
        return popis;
    }

    public void vlozPredmet(Predmet predmet) {
        //
    }

    public Predmet najdiPredmet(String nazevPredmetu) {
        return null;
    }

    public Predmet odeberPredmet(String nazevPredmetu) {
        return null;
    }

    public void vlozPostavu(Postava postava) {
        //
    }

    public Postava getPostava() {
        return null;
    }

    public String seznamVychodu() {
        return String.join(" ", vychody.keySet());
    }
}
