package prikazy;
import logika.Hra;
import logika.Predmet;

public class PrikazProzkoumej implements IPrikaz {
    private Hra hra;

    public PrikazProzkoumej(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) {
            return hra.getAktualniMistnost().dlouhyPopis();
        }

        String nazev = parametry[0];

        if (hra.getBatoh().obsahujeVec(nazev)) {
            return "V batohu: " + nazev;
        }

        Predmet vec = hra.getAktualniMistnost().najdiPredmet(nazev);
        if (vec != null) {
            return "Vidis: " + vec.getPopis();
        }

        return "Nic takoveho tu neni";
    }

    public String getNazev() {
        return "prozkoumej";
    }
}
