import java.util.HashMap;


public class Store {
    private final HashMap<String, Float> flavors = new HashMap<>();
    private final HashMap<String, Float> sizes = new HashMap<>();
    private final String flavor;
    private final String size;
    private final int quantity;

    public Store(String flavor, String size, int quantity) {
        flavors.put("Hawaiian", 100F);
        flavors.put("Overload", 150F);
        flavors.put("Pepperoni", 200F);

        sizes.put("Solo", 0F);
        sizes.put("Double", 75F);
        sizes.put("Family", 150F);

        this.flavor = flavor;
        this.size = size;
        this.quantity = quantity;
    }
    float getPrice() {
        return flavors.get(flavor) + sizes.get(size);
    }
    float getTotal() {
        return getPrice() * quantity;
    }
    boolean checkPrice(float pay, float price) {
        return pay >= price;
    }
    float getChange(float pay, float price) {
        return (pay - price);
    }

}