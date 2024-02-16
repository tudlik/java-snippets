package cz.jty.box;

public class Lahev implements IPolozka {

    private String Nazev;
    private double Objem;

    public Lahev(String Nazev, double Objem) {
        this.Nazev = Nazev;
        this.Objem = Objem;
    }

    public double ziskejObjem() {
        return Objem;
    }

    public String ziskejNazev() {
        return Nazev;
    }
}