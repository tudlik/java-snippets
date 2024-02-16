package cz.jty.developers;

import java.util.HashSet;

public class Programator {
    private String Jmeno;
    private HashSet<String> ProgramovaciJazyky = new HashSet<String>(); //Vytvoření kolekce Programovací jazky pomocí HashSet

    public Programator(String Jmeno, String[] ProgramovaciJazyky){
        this.Jmeno = Jmeno;

        /*
            Zápis jednotlivých programovacích jazyků z pole ProgramovaciJazyky do kolekce HashSet<String> ProgramovaciJazyky
        */
        for (String jazyk : ProgramovaciJazyky) {
            this.ProgramovaciJazyky.add(jazyk);
        }
    }

    public String getJmeno() { return this.Jmeno; }
    public HashSet<String> getProgramovaciJazyky() { return this.ProgramovaciJazyky; }

}
