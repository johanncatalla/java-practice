import javax.swing.JOptionPane;

public class Solution {
    public static void main(String[] args) {
        int arr_count, size;
        String input = "", even = "";
         
         // Get array size and element per nested array
        arr_count = Integer.parseInt(JOptionPane.showInputDialog("Enter number of array elements: "));
        size = Integer.parseInt(JOptionPane.showInputDialog("Enter number of elements in array: "));
        int[][] arr = new int[arr_count][size];
        
        // Define array and construct message
        for (int array = 0; array < arr_count; array++) {
            for (int element = 0; element < size; element++) {
                arr[array][element] = Integer.parseInt(JOptionPane.showInputDialog(null, "Array index["+array+"]["+element+"]:"));
                input += "\nArray index["+array+"]["+element+"]: "+arr[array][element]+"";
                if (arr[array][element] % 2 == 0) {
                    even += "\nEven index["+array+"]["+element+"]: "+arr[array][element]+"";
                } 
            }
        }
        // Show message
        JOptionPane.showMessageDialog(null, "\nInput Numbers:"+input+"\n\nEven Numbers:"+even);
    }
}