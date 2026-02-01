package prikazy;
import logika.Hra;
import logika.Predmet;

public class PrikazVezmi implements IPrikaz {
    private Hra hra;
    public PrikazVezmi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musis zadat nazev predmetu";
        }

        String nazevVeci = parametry[0];
        Predmet vec = hra.getAktualniMistnost().odeberPredmet(nazevVeci);

        if (vec == null) {
            return "To tu neni";
        }

        if (!vec.jePrenositelny()) {
            hra.getAktualniMistnost().vlozPredmet(vec);
            return "To je moc tezke. Neprenositelny predmet";
        }

        if (hra.getBatoh().vlozVec(vec)) {
            return "Vzal jsi " + nazevVeci + " dal ho do batohu.";
        } else {
            hra.getAktualniMistnost().vlozPredmet(vec);
            return "Tvuj batoh je plny/prilis tezky";
        }
    }

    public String getNazev() {
        return "vezmi";
    }
}
