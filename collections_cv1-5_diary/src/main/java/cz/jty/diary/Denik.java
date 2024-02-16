package cz.jty.diary;

public class Denik {
    public void Program() {
        String message = null;
        do{



        }while (message!="zavri");
    }


    void VytiskniMenu() {
        System.out.println("----------------   MENU   ----------------");
        System.out.println("Deník se ovládá následujícími příkazy:");
        System.out.println("- novy: Vytvoření nového záznamu");
        System.out.println("- zaznamy: Zobrazí všechny záznamy");
        System.out.println("- smaz: Odstranění záznamu");
        System.out.println("- zavri: Zavření deníku a ukončení programu");
        System.out.println("----------------   MENU   ----------------");

    }
}
