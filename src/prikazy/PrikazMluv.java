package prikazy;
import logika.Hra;
import logika.Postava;

public class PrikazMluv implements IPrikaz {
    private Hra hra;

    public PrikazMluv(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        if (parametry.length == 0) return "Není s kým mluvit.";

        String jmeno = parametry[0];
        Postava postava = hra.getAktualniMistnost().getPostava(jmeno);

        if (postava == null) {
            return "Nikdo takový tu není.";
        }

        return postava.getDialog();
    }

    public String getNazev() {
        return "mluv";
    }
}
