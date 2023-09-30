public class Store {
    float getPrice(String flavor) {
        if (flavor.equals("Hawaiian")) {
            return 100;
        } else if (flavor.equals("Overload")) {
            return 150;
        } else {
            return 200;
        }
    }
    boolean checkPrice(float pay, float price) {
        return pay >= price;
    }

    float getChange(float pay, float price) {
        return (pay - price);
    }

}
