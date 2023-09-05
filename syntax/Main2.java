// CATALLA, JOHANN SEBASTIAN E. 
import javax.swing.JOptionPane;
public class Main2 {

    public static void main(String[] args) {
    	String input;
    	int num;
    	input = JOptionPane.showInputDialog("Enter num: ");
    	num = Integer.parseInt(input);
    	
    	JOptionPane.showMessageDialog(null, num, "Message", JOptionPane.DEFAULT_OPTION);
    }
}