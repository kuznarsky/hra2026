package prikazy;
import logika.Hra;
import logika.Postava;

public class PrikazPouzij implements IPrikaz {
    private Hra hra;
    public PrikazPouzij(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) return "Co mam pouzit";

        String nazevVeci = parametry[0].toLowerCase();

        if (nazevVeci.equals("maso")) {
            if (!hra.getBatoh().obsahujeVec("maso")) return "Nemas maso";

            Postava pes = hra.getAktualniMistnost().getPostava("pes");
            if (pes != null) {
                hra.getBatoh().vyberVec("maso");
                pes.setTyp("neutral");
                pes.setDialog("(Pes spokojene spi)");
                return "Hodil jsi psovi maso a ted si te nevsima ";
            } else {
                return "Tady neni komu dat maso.";
            }
        }

        return "Tohle nevim, jak pouzit";
    }

    public String getNazev() {
        return "pouzij";
    }
}
