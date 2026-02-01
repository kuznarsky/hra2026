package prikazy;
import logika.Hra;
import logika.Predmet;

public class PrikazPoloz implements IPrikaz {
    private Hra hra;

    public PrikazPoloz(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
       if (parametry.length == 0) return "Nemas nic co by slo polozit";

       String nazevVeci = parametry[0];
        Predmet vec = hra.getBatoh().vyberVec(nazevVeci);

        if (vec == null) {
            return "Takovou vec nemas";
        }

        hra.getAktualniMistnost().vlozPredmet(vec);
        return "Polozil jsi " + nazevVeci + " na zem";
    }

    public String getNazev() {
        return "poloz";
    }
}
