// json serialisierung mit jackson
// dependency in pom.xml: com.fasterxml.jackson.core:jackson-databind
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonSerialize {

    // einfache klasse mit string und numerischen attributen
    static class Product {
        public String name;
        public int id;
        public double price;

        public Product() {} // default konstruktor fuer jackson
        public Product(String name, int id, double price) {
            this.name = name; this.id = id; this.price = price;
        }
    }

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // objekt erstellen und mit werten fuellen
        Product p = new Product("laptop", 42, 999.99);

        // serialisierung: objekt -> json-string
        String json = mapper.writeValueAsString(p);
        System.out.println("serialisiert: " + json);
        // ausgabe: {"name":"laptop","id":42,"price":999.99}

        // deserialisierung: json-string -> objekt
        Product parsed = mapper.readValue(json, Product.class);
        System.out.println("deserialisiert: " + parsed.name + ", " + parsed.price);
    }
}
