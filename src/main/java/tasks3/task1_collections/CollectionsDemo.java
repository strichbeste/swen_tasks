package tasks3.task1_collections;

import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 50; i++) list.add("eintrag-" + i);

        System.out.println("vorher: " + list.size() + " eintraege");

        // iterator verwenden – direkte for-each wuerde ConcurrentModificationException werfen
        Iterator<String> it = list.iterator();
        int index = 0;
        while (it.hasNext()) {
            it.next();
            if (index % 2 == 1) it.remove(); // jedes zweite entfernen
            index++;
        }

        System.out.println("nachher: " + list.size() + " eintraege");
        list.forEach(System.out::println);
    }
}
