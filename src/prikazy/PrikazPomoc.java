package prikazy;
import logika.Hra;

public class PrikazPomoc implements IPrikaz {
    private Hra hra;
    public PrikazPomoc(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "pomoc";
    }
}
