public class Inventory_Class {
    protected String itemName;
    protected int itemAvailable;
    protected double itemPrice;
    protected int transactionNum = 1;
    protected String purchaseHistory = "\n";

    public boolean checkStocks(int numPurchase) {
        return numPurchase <= itemAvailable;
    }

    public void addTransactionNum() {
        transactionNum += 1;
    }

    public int getTransactionNum() {
        return this.transactionNum;
    }

    public int getAvailableItems() {
        return this.itemAvailable;
    }

    public String getProductName() {
        return this.itemName;
    }

    public double getProductPrice() {
        return this.itemPrice;
    }

    public void setPurchaseHistory(String purchase) {
        purchaseHistory += purchase + "\n";
    }

    public String getPurchaseHistory() {
        return purchaseHistory;
    }

    public void clearItems() {
        itemName = "";
        itemAvailable = 0;
        itemPrice = 0.0;
        purchaseHistory = "";
        transactionNum = 0;
    }



}
