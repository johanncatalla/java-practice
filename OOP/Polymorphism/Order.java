import java.util.HashMap;

public class Order extends Menu {
    protected float orders = 0;
    private float discount;
    protected float discounted;

    public Order() {
        super();
    }

    /* I previously declared the "getPrice" and "getTotalPrice" in my abstract class.
    * In this class, these methods will now be defined by using the @Override tag.
    * */
    @Override
    public float getPrice() {
        return menu.get(flavor) + sizes.get(size);
    }

    @Override
    public float getTotalPrice(float price) {
        totalPrice = price * quantity;
        return totalPrice;
    }

    /* Method Overloading by changing parameters
    * My first "getDiscount" function accepts a customer type of integer
    * in which 1 = Regular Customer, 2 = Student Discount, and else = Senior Discount
    * */
    public float getDiscount(int customerType) {
        switch (customerType) {
            case 1: // Regular
                discount = 0;
                break;
            case 2: // STUDENT
                discount = orders * .10F;
                break;
            default:
                discount = orders * .20F;
                break;
        }
        return discount;
    }

    /* Method Overloading by changing parameters
     * In my second "getDiscount" function, the parameter is a string which is the customer type.
     * in which there is "Regular", "STUDENT", and else which means "SENIOR CITIZEN".
     * */
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

    /* Method Overloading by changing data type
    * In my second example, the "getChange" methods do not have the same return
    * data type and parameter data type.
    * */

    public float getChange(float cash) {
        return cash - orders;
    }

    public int getChange(int cash) {
        return (int) (cash - orders);
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

    public float getDiscountedPrice() {
        discounted = orders - discount;
        return discounted;
    }


}
