package cz.jty.box;

public class Krabice<T extends IPolozka> {

    public T Polozka;

    public Krabice(T polozka) {
        this.Polozka = polozka;
    }
}
