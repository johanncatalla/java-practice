// JOhann Sebastian Catalla
// Java Activity prelim AUG 29 2023
// 

import javax.swing.JOptionPane;
public class Main {
    public static void main(String[] args) {
    	int num;
    	String name, namefinal = "";
    	
    	name = JOptionPane.showInputDialog("Enter your name: ");
    	num = Integer.parseInt(JOptionPane.showInputDialog("Enter number of times to display name: "));

    	for (int i = 0; i < num; i++) {
    		namefinal += "\n"+name;
    	}      	
    	JOptionPane.showMessageDialog(null, namefinal);
    }
}