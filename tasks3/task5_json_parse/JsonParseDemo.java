// json parsen: items-array aus string in objekte umwandeln
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.util.*;

public class JsonParseDemo {

    // ziel-klasse fuer jeden item-eintrag
    static class MenuItem {
        public String id;
        public String label;

        @Override
        public String toString() {
            return "id=" + id + (label != null ? ", label=" + label : "");
        }
    }

    public static void main(String[] args) throws Exception {
        // der zu parsende json-string (bereinigt)
        String json = "{\"items\": [{\"id\": \"Open\"},{\"id\": \"OpenNew\", \"label\": \"Open New\"}," +
            "{\"id\": \"ZoomIn\", \"label\": \"Zoom In\"},{\"id\": \"ZoomOut\", \"label\": \"Zoom Out\"}," +
            "{\"id\": \"Copy\"},{\"id\": \"Help\"},{\"id\": \"About\", \"label\": \"About Adobe CVG Viewer...\"}]}";

        ObjectMapper mapper = new ObjectMapper();

        // root-knoten parsen
        JsonNode root = mapper.readTree(json);

        // items-array iterieren
        ArrayNode items = (ArrayNode) root.get("items");
        List<MenuItem> menuItems = new ArrayList<>();

        for (JsonNode node : items) {
            MenuItem item = new MenuItem();
            item.id = node.has("id") ? node.get("id").asText() : null;
            item.label = node.has("label") ? node.get("label").asText() : null;
            menuItems.add(item);
        }

        System.out.println("geparste items:");
        menuItems.forEach(System.out::println);
    }
}
