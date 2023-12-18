import java.util.HashMap;

public class Order extends Menu {
    protected float orders = 0;
    private float discount;
    protected float discounted;

    public Order() {
        super();
    }

    @Override
    public float getPrice() {
        return menu.get(flavor) + sizes.get(size);
    }

    @Override
    public float getTotalPrice(float price) {
        totalPrice = price * quantity;
        return totalPrice;
    }
    public void addOrder() {
        orders += totalPrice;
    }

    public float getTotalOrder() {
        return orders;
    }

    public void setFlavor(String flavor) {
        this.flavor = flavor;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getFlavor() { return this.flavor; }

    public String getSize() { return this.size; }

    public int getQuantity() { return this.quantity; }

    public boolean checkPayment(float pay, float total1) {
        if (pay >= total1) {
            return true;
        } else {
            return false;
        }
    }

    public float getDiscount(String customerType) {
        if (customerType == "Regular") {
            discount = 0;
        } else if (customerType == "STUDENT") {
            discount = orders * .10F;
        } else {
            discount = orders * .20F;
        }
        return discount;
    }

    public float getDiscountedPrice() {
        discounted = orders - discount;
        return discounted;
    }

    public float getChange(float cash) {
        return cash - orders;
    }
}
