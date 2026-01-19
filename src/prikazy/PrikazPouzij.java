package prikazy;
import logika.Hra;

public class PrikazPouzij implements IPrikaz {
    private Hra hra;
    public PrikazPouzij(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        return "";
    }

    public String getNazev() {
        return "pouzij";
    }
}
