import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class GradeCompute extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField inputPrelim;
    private JTextField inputMidterm;
    private JTextField inputSemifinals;
    private JTextField inputFinals;

    public GradeCompute() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
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

    private void onOK() {
        float prelim = Float.parseFloat(inputPrelim.getText());
        float midterm = Float.parseFloat(inputMidterm.getText());
        float semifinals = Float.parseFloat(inputSemifinals.getText());
        float finals = Float.parseFloat(inputFinals.getText());

        DecimalFormat decimal = new DecimalFormat("0.00");

        Compute compute = new Compute(prelim, midterm, semifinals, finals);
        float avg = compute.getAverageGrade();
        String msg = "PRELIM: "+prelim+"\nMIDTERM: "+midterm+"\nSEMIFINALS:"+semifinals+"\nFINALS: "+finals+"\n\nAVERAGE: "+decimal.format(avg);
        JOptionPane.showMessageDialog(null, msg, "COMPUTE AVERAGE", JOptionPane.INFORMATION_MESSAGE);

        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        GradeCompute dialog = new GradeCompute();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
