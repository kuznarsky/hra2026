package logika;

public class Predmet {
    private String nazev;
    private String popis;
    private int vaha;
    private boolean prenositelny;

    public Predmet(String nazev, String popis, boolean prenositelny, int vaha) {
        this.nazev = nazev;
        this.popis = popis;
        this.vaha = vaha;
        this.prenositelny = prenositelny;
    }

    public String getNazev() {
        return nazev;
    }

    public String getPopis() {
        return popis;
    }

    public boolean jePrenositelny() {
        return prenositelny;
    }

    public int getVaha() {
        return vaha;
    }

    @Override
    public String toString() {
        return nazev;
    }
}
