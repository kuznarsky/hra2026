package prikazy;
import logika.Hra;

public class PrikazVezmi implements IPrikaz {
    private Hra hra;
    public PrikazVezmi(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "vezmi";
    }
}
