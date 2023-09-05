public class Loop {
    public static int num = 10;
    public static void main(String[] args) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
            System.out.print(" ".repeat(j));
            System.out.print("snek");
            System.out.println("");
            }
            for (int k = num; k > 0; k--) {
                System.out.print(" ".repeat(k));
                System.out.print("snek");
                System.out.println("");
            }
        }
        
    }
}

