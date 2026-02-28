package prikazy;
import logika.Hra;
import logika.Mistnost;
import logika.Postava;
import logika.Predmet;

public class PrikazVezmi implements IPrikaz {
    private Hra hra;
    public PrikazVezmi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musíte zadat název předmětu";
        }
        Mistnost aktualni = hra.getAktualniMistnost();

        String nazevVeci = parametry[0];

        Predmet nalezenaVec = aktualni.najdiPredmet(nazevVeci);

        if (nalezenaVec == null) {
            return "To tu není";
        }

        if (!nalezenaVec.jePrenositelny()) {
            return "To je moc těžké. Nepřenositelný předmět";
        }

        if (nazevVeci.equals("klíč") && hra.getAktualniMistnost().getNazev().equals("Kancelář velitele")) {
            Postava pes = hra.getAktualniMistnost().getPostava("pes");

            if (pes != null && pes.getTyp().equals("překážka")) {
                return "Pokusil/a jste se vzít klíč a pes na vás zaútočil.";
            }
        }
        Predmet vec = aktualni.odeberPredmet(nazevVeci);

        if (hra.getBatoh().vlozVec(vec)) {
            return "Vzal/a jste " + nazevVeci + " dal/a ho do batohu.";
        } else {
            hra.getAktualniMistnost().vlozPredmet(vec);
            return "Tvůj batoh je už plný, nebo příliš těžký";
        }
    }

    public String getNazev() {
        return "vezmi";
    }
}
