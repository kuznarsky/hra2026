package prikazy;
import logika.Hra;

public class PrikazNapoveda implements IPrikaz {
    private Hra hra;
    public PrikazNapoveda(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "jdi";
    }
}
