package cz.jty.box;

public class Kniha implements IPolozka {

    private String Nazev;

    public Kniha(String Nazev) {
        this.Nazev = Nazev;
    }

    public String ziskejNazev() {
        return Nazev;
    }
}