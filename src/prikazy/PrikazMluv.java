package prikazy;
import logika.Hra;

public class PrikazMluv implements IPrikaz {
    private Hra hra;
    public PrikazMluv(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "jdi";
    }
}
