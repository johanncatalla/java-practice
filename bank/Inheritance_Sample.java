public class Inheritance_Sample extends Encapsulation_Sample {
    public void deposit(String accountType, float amount) {
        if (accountType == "SAVINGS") {
            savings_balance += amount*1.02;
        } else {
            current_balance += amount;
        }
        transactionNo += 1;
    }
    public void withdraw(String accountType, float amount) {
        if (accountType == "SAVINGS") {
            savings_balance -= amount;
        } else {
            current_balance -= amount;
        }
        transactionNo += 1;
    }
    public int getTransactionNo() {
        return this.transactionNo;
    }
}
