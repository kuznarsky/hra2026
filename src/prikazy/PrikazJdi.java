package prikazy;
import logika.Hra;

public class PrikazJdi implements IPrikaz {
    private Hra hra;
    public PrikazJdi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "jdi";
    }
}
