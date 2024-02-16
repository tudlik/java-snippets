package cz.jty.developers;


import java.util.HashSet;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        String name;
        String language;
        Scanner scanner = new Scanner(System.in);
        Programator[] developers = new Programator[3];

        HashSet<String> allLanguages; // jazyky, ktere umi vsichni dohromady
        HashSet<String> everybodyKnowsLanguage; // jazyky, ktere umi vsichni - kazdy z nich umi tento jazyk


        for (int i = 0; i < 3; i++) {
            System.out.println("Zadejte " + (i + 1) + ". programátora");
            System.out.print("Jméno: ");
            name = scanner.nextLine();
            System.out.print("Programovací jazyky (oddělujte čárkou a mezerou): ");
            language = scanner.nextLine();
            String[] languages = language.split(", ");
            developers[i] = (new Programator(name, language.split(", ")));
        }

        allLanguages = new HashSet<String>(developers[0].getProgramovaciJazyky());
        everybodyKnowsLanguage = new HashSet<String>(developers[0].getProgramovaciJazyky());

        for (int i = 1; i < 3; i++) {
            allLanguages.addAll(developers[i].getProgramovaciJazyky());
            everybodyKnowsLanguage.retainAll(developers[i].getProgramovaciJazyky());
        }

        System.out.println();
        System.out.print("Všechny jazyky: ");
        printLanguage(allLanguages);
        System.out.println();
        System.out.print("Společné jazyky: ");
        printLanguage(everybodyKnowsLanguage);
        System.out.println();
        System.out.println();


        for (Programator developer : developers) {
            HashSet<String> lang = new HashSet<>(developer.getProgramovaciJazyky());

            for (Programator otherDeveloper : developers) {
                if (developer != otherDeveloper) {
                    lang.removeAll(otherDeveloper.getProgramovaciJazyky());
                }
            }

            System.out.print("Jazyky, které umí jen " + developer.getJmeno() + ": ");
            printLanguage(lang);
            System.out.println();


        }

        scanner.close();
    }

    static void printLanguage(HashSet<String> languages) {
        for (String language : languages) {
            System.out.print(language + ", ");
        }
    }
}

