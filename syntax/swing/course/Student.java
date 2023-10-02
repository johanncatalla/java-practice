import javax.swing.*;
import java.awt.event.*;

public class
Student extends JDialog {
    private JPanel contentPane;
    private JTextField nameField;
    private JTextField addressField;
    private JComboBox comboBoxCourse;
    private JTextArea listStudents;
    private JButton ADDCOURSEButton;
    private JButton SUBMITINFORMATIONButton;

    public Student() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(SUBMITINFORMATIONButton);

        SUBMITINFORMATIONButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buttonSubmit();
            }
        });

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

        SUBMITINFORMATIONButton.addActionListener(e -> buttonSubmit());
        ADDCOURSEButton.addActionListener(e -> onAddCourse());
    }

    private void onAddCourse() {
        String inputCourse;
        inputCourse = JOptionPane.showInputDialog("Enter Course: ");
        comboBoxCourse.addItem(inputCourse);
    }
    String studentList;
    private void buttonSubmit() {
        studentList = "";
        String name, course, address, studentInfo;
        name = nameField.getText();
        course = comboBoxCourse.getSelectedItem().toString();
        address = addressField.getText();

        StudentInfo info = new StudentInfo(name, address, course);

        studentList = studentList + info.getName()
                +"\t"+info.getAddress()
                +"\t"+info.getCourse()
                +"\n";
        listStudents.setText("Name: \tAddress: \tCourse:\n"+studentList);
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Student dialog = new Student();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
