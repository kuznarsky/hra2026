package prikazy;
import logika.Hra;

public class PrikazPoloz implements IPrikaz {
    private Hra hra;
    public PrikazPoloz(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "poloz";
    }
}
