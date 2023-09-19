import javax.swing.*;
import java.awt.event.*;

public class Tuition extends JDialog {
    String name, program, year, modeOfPayment, paymentDescription;
    String courseDesc="";
    double fee, amountDiscountInterest, totalFee;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JComboBox course;
    private JComboBox yrLevel;
    private JTextField studentName;
    private JTextField tuitionFee;
    private JRadioButton cashRadioButton;
    private JRadioButton installmentRadioButton;

    public Tuition() {
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

        cashRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCash();
            }
        });

        installmentRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onInstallment();
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

    private void onCash() {
        Pay pay = new Pay();
        modeOfPayment = "CASH";
        paymentDescription = "DISCOUNT";
        fee = Double.parseDouble(tuitionFee.getText());
        amountDiscountInterest = pay.getDiscount(.10, fee);
        totalFee = pay.computeDiscount(fee, amountDiscountInterest);
        JOptionPane.showMessageDialog(null, "CASH\nFEE: "+fee
                    +"\nDISCOUNT: "+amountDiscountInterest+"\nDISCOUNTED FEE: "+totalFee);
    }

    private void onInstallment() {
        dispose();
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
        Tuition dialog = new Tuition();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

