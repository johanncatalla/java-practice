public class Pay {
    double getDiscountInterest(double percentage, double fee) {
        double amt;
        amt = fee * percentage;
        return amt;
    }

    double computeDiscount(double price, double discount) {
        return price - discount;
    }
    double computeInterest(double price, double interest) { return price + interest; }
}
