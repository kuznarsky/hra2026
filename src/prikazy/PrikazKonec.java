package prikazy;
import logika.Hra;

public class PrikazKonec implements IPrikaz {
    private Hra hra;
    public PrikazKonec(Hra hra) {
        this.hra = hra;
    }

    public String proved(String[] parametry) {
        hra.setKonecHry(true);
        return "Hra ukončena uživatelem";
    }

    public String getNazev() {
        return "konec";
    }
}
