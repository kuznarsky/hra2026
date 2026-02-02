package logika;

public class Postava {
    private String jmeno;
    private String dialog;
    private String typ;

    public Postava(String jmeno, String dialog, String typ) {
        this.jmeno = jmeno;
        this.dialog = dialog;
        this.typ = typ;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getDialog() {
        return jmeno + ": \"" + dialog + "\"";
    }

    public void setDialog(String novyDialog) {
        this.dialog = novyDialog;
    }

    public String getTyp() { return typ; }

    public void setTyp(String novyTyp) {
        this.typ = novyTyp;
    }

 //   public void setPozadovanyPredmet(Predmet predmet) {
        //
  //   }
}
