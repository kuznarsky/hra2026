package prikazy;
import logika.Hra;
import logika.Mistnost;

public class PrikazJdi implements IPrikaz {
    private Hra hra;

    public PrikazJdi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return "Musis zadat smer (napr. jdi sever)";
        }

        String smer = parametry[0];
        Mistnost aktualni = hra.getAktualniMistnost();
        Mistnost sousedni = aktualni.vratVychod(smer);

        if (sousedni == null) {
            return "Tam se odsud jit neda";
        }

        hra.setAktualniMistnost(sousedni);
        return sousedni.dlouhyPopis();
    }

    public String getNazev() {
        return "jdi";
    }
}
