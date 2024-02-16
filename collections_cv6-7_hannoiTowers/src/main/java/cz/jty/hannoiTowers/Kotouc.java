package cz.jty.hannoiTowers;

public class Kotouc {
    private final int id; // ID kotouče, které se poté bude číst k vyhodnocení
    private final String text; // Obsahuje grafiku kotouče

    public Kotouc(int id, String text){
        this.id = id;
        this.text = text;
    }

    public int getID() { return this.id; }
    public String getText() { return this.text; }

    }

