import java.util.*;

// demo: collection erstellen, iterieren, jedes zweite element entfernen
public class CollectionsDemo {
    public static void main(String[] args) {
        // 50 strings erstellen
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            list.add("eintrag-" + i);
        }

        System.out.println("vorher: " + list.size() + " eintraege");

        // iterator verwenden um waehrend iteration zu entfernen
        // direkte for-each schleife wuerde ConcurrentModificationException werfen!
        Iterator<String> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            it.next();
            // jedes zweite element entfernen (index 1, 3, 5, ...)
            if (index % 2 == 1) {
                it.remove(); // sicheres entfernen waehrend iteration
            }
            index++;
        }

        System.out.println("nachher: " + list.size() + " eintraege");
        list.forEach(System.out::println);
    }
}
