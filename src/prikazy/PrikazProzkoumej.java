package prikazy;
import logika.Hra;

public class PrikazProzkoumej implements IPrikaz {
    private Hra hra;
    public PrikazProzkoumej(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "jdi";
    }
}
