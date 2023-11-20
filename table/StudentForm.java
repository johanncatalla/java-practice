import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.*;

public class StudentForm extends JDialog {
    private JPanel contentPane;
    private JTabbedPane tabbedPane1;
    private JTable table1;
    private JButton DISPLAYTABLEButton;
    private JButton ADDSTUDENTButton;
    private JButton CANCELButton;
    private JTextField lastName;
    private JTextField firstName;
    private JTextField middleInitial;
    private JComboBox yrLevelBox;
    private JComboBox courseBox;
    private JRadioButton maleRadioButton;
    private JRadioButton femaleRadioButton;
    private JComboBox studentTypeBox;
    private JButton DISPLAYTABLEButton1;
    private JButton SUBMITGRADEButton;
    private JComboBox studentNameCombo;
    private JTextField prelimGradeField;
    private JTextField midtermGradeField;
    private JTextField semifinalGradeField;
    private JTextField finalGradeField;
    private JTable table2;
    private JButton buttonOK;
    private JButton buttonCancel;
    private int count=0, xrow=0;
    private String name=" ",gender="", coursegrade="", studentNumber;

    public StudentForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        DISPLAYTABLEButton.addActionListener( e -> onDisplayTableInfo() );
        DISPLAYTABLEButton1.addActionListener( e -> onDisplayTableGrade() );
        femaleRadioButton.addActionListener( e -> addFemale() );
        maleRadioButton.addActionListener( e -> addMale() );
        ADDSTUDENTButton.addActionListener( e -> addStudent() );
        SUBMITGRADEButton.addActionListener( e -> submitGrade() );
    }

    private void addFemale() //method for checkbox Female
    {
        gender="F";
        maleRadioButton.setSelected(false);
    }

    private void addMale() //method for checkbox Male
    {
        gender="M";
        femaleRadioButton.setSelected(false);
    }

    public void addStudent() //method for button ADD STUDENT
    {
        DefaultTableModel studentList = (DefaultTableModel)
                table1.getModel();
        name = lastName.getText()+", "+firstName.getText()+" "+middleInitial.getText();
        count++;
        String studentName = name.toUpperCase();
        String studentCourse = courseBox.getSelectedItem().toString();
        String studentYear = yrLevelBox.getSelectedItem().toString();
        String studentGender = gender;
        String studentType = studentTypeBox.getSelectedItem().toString();
        //identify the values to be stored in the table
        Object[] row = {count, studentName, studentYear, studentCourse, studentGender, studentType};
        //add values to the table row
        studentList.addRow(row);
        //insert studentName in the combo box located in GRADE tab

        studentNameCombo.insertItemAt(studentList.getValueAt(xrow,1).toString(),xrow);
        xrow++;
    }

    public void submitGrade() //method for SUBMIT GRADE button
    {
        DefaultTableModel studentGradeList = (DefaultTableModel) table2.getModel();
        DefaultTableModel studentList = (DefaultTableModel) table1.getModel();
        double prelim, midterm, semifinal,finals,grade;
        String remarks="", equivalent="",studName;
        studName = studentNameCombo.getSelectedItem().toString();
        prelim = Double.parseDouble(prelimGradeField.getText());
        midterm = Double.parseDouble(midtermGradeField.getText());
        semifinal = Double.parseDouble(semifinalGradeField.getText());
        finals = Double.parseDouble(finalGradeField.getText());
        grade = prelim * .20 + midterm *.20+ semifinal * .20 + finals *.40;
        if(grade>=75)
            remarks = "PASSED";
        else
            remarks = "FAILED";
        //searching students from student table
        for(int rowsearch=0;rowsearch<studentList.getRowCount();rowsearch++) {
            if(studName==studentList.getValueAt(rowsearch,1)) {
                //matching the selected student name from the combobox
                coursegrade=studentList.getValueAt(rowsearch,3).toString();
                studentNumber=studentList.getValueAt(rowsearch,0).toString();
            }
        }
        Object[] row = {studentNumber,studName,coursegrade,prelim,midterm,semifinal,finals,grade,remarks};
        studentGradeList.addRow(row);
    }


    private void onDisplayTableGrade() {
        table2.setModel(new DefaultTableModel(
                null,
                new String[] {"Student No.", "Name", "Course", "Prelim Grade", "Midterm Grade", "Semi-Final Grade", "Final Grade", "Semester Grade", "Remarks"}
        ));
    }

    private void onDisplayTableInfo() {
        table1.setModel(new DefaultTableModel(
                null,
                new String[] {"Student NO.", "Name", "Year Level", "Course", "Gender", "Student Type"}
        ));
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        StudentForm dialog = new StudentForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
