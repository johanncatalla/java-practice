import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GradesClass extends JDialog {
    String firstName, lastName, middle, course, name;
    int year, prelim, midterm, finals;
    float avg;
    double equivalent;
    String status, averageTxt, subject, gradeRes;

    private JPanel contentPane;
    private JButton buttonCancel;
    private JTextArea resultArea;
    private JTextField lastNameField;
    private JTextField firstNameField;
    private JTextField middleField;
    private JComboBox yearCombo;
    private JComboBox courseCombo;
    private JButton computeButton;
    private JButton clearButton;
    private JTextField prelimField;
    private JComboBox subjectCombo;
    private JTextField midtermField;
    private JTextField finalField;
    private JTextField averageField;

    public GradesClass() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(computeButton);

        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCompute();
            }
        });

        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onClear();
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
        clearButton.addActionListener(e -> onClear());
    }

    String msg = "";
    private void onCompute() {


        DecimalFormat decimal = new DecimalFormat("0.00");

        firstName = firstNameField.getText();
        lastName = lastNameField.getText();
        middle = middleField.getText();
        course = courseCombo.getSelectedItem().toString();
        year = Integer.parseInt(yearCombo.getSelectedItem().toString());
        StudentClass student = new StudentClass(lastName, firstName, middle, course, year);
        name = student.getName();

        subject = subjectCombo.getSelectedItem().toString();
        prelim = Integer.parseInt(prelimField.getText());
        midterm = Integer.parseInt(midtermField.getText());
        finals = Integer.parseInt(finalField.getText());
        student.setGrades(subject, prelim, midterm, finals);

        avg = student.getAvg();
        averageTxt = decimal.format(avg);
        status = student.checkGrade(avg);
        equivalent = student.convert(avg);

        msg += "\n"+subject+"\t"+decimal.format(prelim)+"\t"+decimal.format(midterm)+"\t"+decimal.format(finals)+"\t"
                +averageTxt+"\t"+decimal.format(equivalent)+"\t"+status;

        averageField.setText(averageTxt);
        resultArea.setText("Student Name: "+student.getName()+"\nCourse: "+student.getCourse()+"\nYear: "+student.getYear()
                +"\n\nSubject\t"+"Prelim\t"+"Midterm\t"+"Finals\t"+"Average\t"
                +"Equivalent\t"+"Status\n"+msg);
    }

    private void onClear() {
        prelimField.setText("");
        midtermField.setText("");
        finalField.setText("");
        averageField.setText("");
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        GradesClass dialog = new GradesClass();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
