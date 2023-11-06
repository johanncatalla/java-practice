public class Item_Class extends Inventory_Class {
    private double totalAmount;
    private int lastPurchase;
    public Item_Class(String itemName, double itemPrice, int avaiLableItem) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemAvailable = avaiLableItem;
    }

    public void purchaseItem(int itemQuantity) {
        this.itemAvailable -= itemQuantity;
        this.lastPurchase = itemQuantity;
    }

    public double getTotalAmount() {
        return this.itemPrice * lastPurchase;
    }

    public int getLastPurchase() {
        return this.lastPurchase;
    }

    public int getProductQuantity() {
        return this.lastPurchase;
    }

}
