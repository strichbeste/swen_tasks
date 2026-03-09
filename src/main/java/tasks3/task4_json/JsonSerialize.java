package tasks3.task4_json;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialize {

    static class Product {
        public String name;
        public int id;
        public double price;
        public Product() {}
        public Product(String name, int id, double price) {
            this.name = name; this.id = id; this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // serialisierung: objekt -> json
        Product p = new Product("laptop", 42, 999.99);
        String json = mapper.writeValueAsString(p);
        System.out.println("json: " + json);

        // deserialisierung: json -> objekt
        Product parsed = mapper.readValue(json, Product.class);
        System.out.println("name: " + parsed.name + ", preis: " + parsed.price);
    }
}
