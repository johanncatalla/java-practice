import java.util.HashMap;

public abstract class Menu {
    protected HashMap<String, Float> menu = new HashMap<String, Float>();
    protected HashMap<String, Float> sizes = new HashMap<String, Float>();
    protected String flavor;
    protected int quantity;
    protected String size;

    protected float totalPrice;
    public Menu() {
        menu.put("Pepperoni", 100F);
        menu.put("Hawaiian", 150F);
        menu.put("Beef", 200F);
        menu.put("Veggie", 120F);

        sizes.put("Solo", 0F);
        sizes.put("Double", 50F);
        sizes.put("Family", 75F);

    }

    public abstract float getPrice();

    public abstract float getTotalPrice(float price);
}
