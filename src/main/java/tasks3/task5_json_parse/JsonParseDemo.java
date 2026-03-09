package tasks3.task5_json_parse;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.*;
import java.util.*;

public class JsonParseDemo {

    static class MenuItem {
        public String id;
        public String label;
        @Override public String toString() {
            return "id=" + id + (label != null ? ", label=" + label : "");
        }
    }

    public static void main(String[] args) throws Exception {
        String json = "{\"items\": [{\"id\": \"Open\"},{\"id\": \"OpenNew\", \"label\": \"Open New\"}," +
            "{\"id\": \"ZoomIn\", \"label\": \"Zoom In\"},{\"id\": \"Help\"},{\"id\": \"About\", \"label\": \"About Adobe CVG Viewer...\"}]}";

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(json);
        ArrayNode items = (ArrayNode) root.get("items");

        List<MenuItem> result = new ArrayList<>();
        for (JsonNode node : items) {
            MenuItem item = new MenuItem();
            item.id    = node.has("id")    ? node.get("id").asText()    : null;
            item.label = node.has("label") ? node.get("label").asText() : null;
            result.add(item);
        }
        result.forEach(System.out::println);
    }
}
