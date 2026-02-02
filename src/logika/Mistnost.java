package logika;

import java.util.HashMap;
import java.util.Map;

public class Mistnost {
    private String nazev;
    private String popis;
    private Map<String, Mistnost> vychody;
    private Map<String, Predmet> predmety = new HashMap<>();
    private Map<String, Postava> postavy = new HashMap<>();

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
        return "\n--------------\n" +
                "Jsi v lokaci: " + nazev + "\n" +
                "Popis: " + popis + "\n" +
                "Vychody: " + seznamVychodu() + "\n" +
                "Predmety: " + seznamPredmetu() + "\n" +
                "Postavy: " + seznamPostav() +
                "\n----------------------";
    }

    public void vlozPredmet(Predmet predmet) {
        predmety.put(predmet.getNazev(), predmet);
    }

    public Predmet najdiPredmet(String nazevPredmetu) {
        return predmety.get(nazevPredmetu);
    }

    public Predmet odeberPredmet(String nazevPredmetu) {
        return predmety.remove(nazevPredmetu.toLowerCase());
    }

    public void vlozPostavu(Postava postava) {
        postavy.put(postava.getJmeno(), postava);
    }

    public Postava getPostava(String jmeno) {
        return postavy.get(jmeno);
    }

    public String seznamVychodu() {
        return String.join(" ", vychody.keySet());
    }

    public String seznamPredmetu() {
        return String.join(" ", predmety.keySet());
    }

    public String seznamPostav() {
        return String.join(" ", postavy.keySet());
    }
}
