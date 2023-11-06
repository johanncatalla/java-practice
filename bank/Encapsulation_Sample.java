public class Encapsulation_Sample {
    protected double savings_balance;
    protected double current_balance;
    protected String last_accType;
    protected double last_amt;
    protected int transactionNo;
    protected String transactionHistory;
    public boolean checkCurrentBalance(double withdraw) {
        if (current_balance >= withdraw) {
            return true;
        }
        return false;
    }
    public boolean checkSavingsBalance(double withdraw) {
        if (savings_balance >= withdraw) {
            return true;
        }
        return false;
    }
    public double getSavingsBalance() {
        return this.savings_balance;
    }
    public double getCurrentBalance() {
        return this.current_balance;
    }
    public String getLastAcc() {
        return this.last_accType;
    }
    public double getLastAmt() {
        return this.last_amt;
    }

    //setters
    public void setLast_accType(String accType) {
        this.last_accType = accType;
    }
    public void setLast_amt(float last_amt) {
        this.last_amt = last_amt;
    }
    public void setTransactionHistory(String msg) {
        this.transactionHistory = msg;
    }
    public String getTransactionHistory() {
        return this.transactionHistory;
    }
}
