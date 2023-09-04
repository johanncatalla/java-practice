// Johann Sebastian Catalla
import javax.swing.JOptionPane;
public class Solution {
    public static void main(String[] args) {
    	int num = 0, sum = 0;
    	while (num >= 0) {
    		num = Integer.parseInt(JOptionPane.showInputDialog("Enter num: "));
    		if (num >=0){
    			sum += num;
    		}
    	}
    	JOptionPane.showMessageDialog(null, "Sum is: "+sum);   
    }	
}