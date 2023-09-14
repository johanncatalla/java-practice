public class Price {
    private float productPrice;
    private int productQuantity;

    // Class Constructor
    Price(float price, int quantity) {
        this.productPrice = price;
        this.productQuantity = quantity;
    }

    float getTotalAmount() {
        float finalAmount = productPrice * productQuantity;
        return finalAmount;
    }
}
