import javax.swing.*;
import java.awt.event.*;

public class
Student extends JDialog {
    private JPanel contentPane;
    private JButton buttonSubmit;
    private JButton buttonCancel;
    private JTextField nameField;
    private JTextField addressField;
    private JComboBox comboBoxCourse;

    public Student() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonSubmit);

        buttonSubmit.addActionListener(new ActionListener() {
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

        buttonSubmit.addActionListener(e -> buttonSubmit());
    }


    private void buttonSubmit() {
        String name, course, address, studentInfo;
        name = nameField.getText();
        course = comboBoxCourse.getSelectedItem().toString();
        address = addressField.getText();

        StudentInfo info = new StudentInfo(name, address, course);
        JOptionPane.showMessageDialog(null, "Name: "+info.getName()
                +"\nAddress: "+info.getAddress()+"\nCourse: "+info.getCourse(), "STUDENT INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        dispose();
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
