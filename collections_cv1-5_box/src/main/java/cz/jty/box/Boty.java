package cz.jty.box;

public class Boty implements IPolozka {

    private int Velikost;
    private String Nazev;

    public Boty(String Nazev, int Velikost) {
        this.Velikost = Velikost;
        this.Nazev = Nazev;
    }


    public String ziskejNazev() {
        return Nazev;
    }

    public int ziskejVelikost() {
        return Velikost;
    }
}