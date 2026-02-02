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
            return "Musis zadat nazev predmetu";
        }
        Mistnost aktualni = hra.getAktualniMistnost();

        String nazevVeci = parametry[0];

        Predmet nalezenaVec = aktualni.najdiPredmet(nazevVeci);

        if (nalezenaVec == null) {
            return "To tu neni";
        }

        if (!nalezenaVec.jePrenositelny()) {
            return "To je moc tezke. Neprenositelny predmet";
        }

        if (nazevVeci.equals("klic") && hra.getAktualniMistnost().getNazev().equals("Kancelar_velitele")) {
            Postava pes = hra.getAktualniMistnost().getPostava("pes");

            if (pes != null && pes.getTyp().equals("prekazka")) {
                return "Pokusil ses vzit klic ale pes na tebe vyjel";
            }
        }
        Predmet vec = aktualni.odeberPredmet(nazevVeci);

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
