package prikazy;
import logika.Hra;
import logika.Predmet;

public class PrikazPoloz implements IPrikaz {
    private Hra hra;

    public PrikazPoloz(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
       if (parametry.length == 0) return "Nemáte nic, co by šlo položit";

       String nazevVeci = parametry[0];
        Predmet vec = hra.getBatoh().vyberVec(nazevVeci);

        if (vec == null) {
            return "Takovou věc nemáte";
        }

        hra.getAktualniMistnost().vlozPredmet(vec);
        return "Položil/a jste " + nazevVeci + " na zem";
    }

    public String getNazev() {
        return "poloz";
    }
}
