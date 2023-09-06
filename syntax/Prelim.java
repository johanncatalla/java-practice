import javax.swing.JOptionPane;

public class Prelim {
    public static void main(String[] args) {
        int size, replaceNum, newNum;
        size = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter array size: "));
        boolean replace = false;
        String originalArrMsg = "", newArrMsg = "";

        int[] originalArr = new int[size];
        int[] newArr = new int[size];

        for (int i = 0; i < size; i++) {
            int temp = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter array index["+i+"]: "));
            originalArr[i] = temp;
            newArr[i] = temp;
        }
        while (!replace) {
            replaceNum = Integer.parseInt(JOptionPane.showInputDialog("Enter number to be replaced: "));
            for (int i = 0; i < size; i++) {
                if (replaceNum == originalArr[i]) {
                    replace = true;
                    newNum = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter new number: "));
                    newArr[i] = newNum;
                } else if (i==size-1 && !replace) {
                    JOptionPane.showMessageDialog(null, "Number not found, enter a different number.");
                }
            }
        }
        for (int i = 0; i < size; i++) {
            originalArrMsg += originalArr[i] + " ";
            newArrMsg += newArr[i] + " ";
        }
        JOptionPane.showMessageDialog(null, "Original Array: ["+originalArrMsg+"]"+"\nNew Array:        ["+newArrMsg+"]");

    }
}