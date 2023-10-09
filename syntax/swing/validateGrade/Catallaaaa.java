import javax.swing.*;
import java.awt.event.*;

public class Catallaaaa extends JDialog {
    private JPanel contentPane;
    private JButton verifyGrades;
    private JButton printReport;

    private JTextField grade1;
    private JTextField grade2;
    private JTextField grade3;
    private JTextField grade4;
    private JTextField grade5;
    
    private JTextField student1;
    private JTextField student2;
    private JTextField student3;
    private JTextField student4;
    private JTextField student5;
    private JLabel verify1;
    private JLabel verify2;
    private JLabel verify3;
    private JLabel verify4;
    private JLabel verify5;


    public Catallaaaa() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(verifyGrades);

        verifyGrades.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        printReport.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
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
    }

    int passed = 0, failed = 0, invalid = 0;
    private void onOK() {
        int[] grades = {Integer.parseInt(grade1.getText()), Integer.parseInt(grade2.getText()), Integer.parseInt(grade3.getText()), Integer.parseInt(grade4.getText()), Integer.parseInt(grade5.getText())};
        JLabel[] remarks = {verify1, verify2, verify3, verify4, verify5};
        for (int i = 0; i < 5; i++) {
            String remark = "";
            Grade grade = new Grade();
            remark = grade.Verify(grades[i]);
            remarks[i].setText(remark);
            if (remark == "PASSED") {
                passed += 1;
            } else if (remark == "FAILED") {
                failed += 1;
            } else {
                invalid += 1;
            }
        }
    }

    private void onCancel() {
        String report = "STUDENT GRADE REPORT";
        report += "\n\nPASSED: "+passed+"\nFAILED: "+failed+"\nINVALID GRADE: "+invalid;
        JOptionPane.showMessageDialog(null, report, "STUDENT GRADE REPORT", JOptionPane.INFORMATION_MESSAGE);
        dispose();
    }

    public static void main(String[] args) {
        Catallaaaa dialog = new Catallaaaa();
        dialog.setTitle("STUDENT GRADE REPORT");
        dialog.pack();
        dialog.setVisible(true);

        System.exit(0);
    }
}
