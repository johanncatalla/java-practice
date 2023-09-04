import javax.swing.JOptionPane;



public class Options {
	public static void main(String[] args) {
		String name;
		Object select_course, select_yr;
		String[] courses = {"BSCS", "BSIT", "BSEMC", "BSIS"};
		String[] level = {"1", "2", "3", "4"};
		
		name = JOptionPane.showInputDialog("Enter name: ");
		select_course = JOptionPane.showInputDialog(null, "Select course: ", "Item Selection", JOptionPane.INFORMATION_MESSAGE, null, courses, courses[0]);
		select_yr = JOptionPane.showInputDialog(null, "Select year level: ", "Item Selection", JOptionPane.INFORMATION_MESSAGE, null, level, level[0]);
		
		JOptionPane.showMessageDialog(null, "Name: "+name+"\nProgram: "+select_course+"\nYear Level: "+select_yr, "Selected Item", JOptionPane.INFORMATION_MESSAGE);
	}
}
/*
 Input name
 Select course
 select year level
 Display input name, course and year level
 */