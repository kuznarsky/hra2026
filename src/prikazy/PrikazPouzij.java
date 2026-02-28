package prikazy;
import logika.Hra;
import logika.Postava;

public class PrikazPouzij implements IPrikaz {
    private Hra hra;
    public PrikazPouzij(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) return "Co mám použít?";

        String nazevVeci = parametry[0].toLowerCase();

        if (nazevVeci.equals("maso")) {
            if (!hra.getBatoh().obsahujeVec("maso")) return "Nemáte maso.";

            Postava pes = hra.getAktualniMistnost().getPostava("pes");
            if (pes != null) {
                hra.getBatoh().vyberVec("maso");
                pes.setTyp("neutral");
                pes.setDialog("(Pes spokojeně spí)");
                return "Hodili jste psovi maso a teď si vás nevšímá.";
            } else {
                return "Tady není komu dát maso.";
            }
        }

        if (nazevVeci.equals("paklíč")) {
            if (!hra.getBatoh().obsahujeVec("paklíč")) return "Nemáš paklíč. Možná ho zkuste najít?";

            Postava zamcenacela = hra.getAktualniMistnost().getPostava("zamcenacela");
            if (zamcenacela != null) {
                hra.getBatoh().vyberVec("paklíč");
                zamcenacela.setTyp("neutral");
                return "Odemknuli jste celu";
            } else {
                return "Tady není jak použít paklíč";
            }
        }

        return "Tohle nevím, jak použít";
    }

    public String getNazev() {
        return "použij";
    }
}
