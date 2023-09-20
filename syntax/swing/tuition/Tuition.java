import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.util.Objects;

public class Tuition extends JDialog {
    String name, program, year, modeOfPayment, paymentDescription = "", install;
    String courseDesc="";
    double fee, amountDiscountInterest, totalFee;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
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

        buttonOK.addActionListener(e -> onOK());
        buttonCancel.addActionListener(e -> onCancel());
        cashRadioButton.addActionListener(e -> onCash());
        installmentRadioButton.addActionListener(e -> onInstallment());

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(e -> onCancel(), KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
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
        DecimalFormat decimal = new DecimalFormat("0.00");
        modeOfPayment = "INSTALLMENT";
        totalFee = Double.parseDouble(tuitionFee.getText());
        install = decimal.format(totalFee / 5);
        paymentDescription = "DOWN PAYMENT: "+install+"\nPRELIM: "+install+"\nMIDTERM: "+install
                +"\nSEMIFINALS: "+install+"\nFINALS: "+install;
        JOptionPane.showMessageDialog(null, "INSTALLMENT\n"+paymentDescription+"\nTOTAL: "+totalFee);
    }

    private void onOK() {
        name = studentName.getText();
        program = Objects.requireNonNull(course.getSelectedItem()).toString();
        if (program.equals("BSIT"))
            courseDesc = "BS Information Technology";
        else if (program.equals("BSCS"))
            courseDesc = "BS Computer Science";
        else
            courseDesc = "BS Entertainment and Multimedia Computing";
        year = Objects.requireNonNull(yrLevel.getSelectedItem()).toString();
        if (modeOfPayment.equals("CASH")) {
            JOptionPane.showMessageDialog(null, "PAYMENT DETAILS\nNAME: "+name
                    +"\nCOURSE: "+courseDesc+"\nYEAR LEVEL: "+year+"\nFEE: "+fee+"\n\nMODE OF PAYMENT: "+modeOfPayment
                    +"\n"+paymentDescription+": "+amountDiscountInterest+"\nTOTAL FEE: "+totalFee);
        } else {
            JOptionPane.showMessageDialog(null, "PAYMENT DETAILS\nNAME: "+name
                    +"\nCOURSE: "+courseDesc+"\nYEAR LEVEL: "+year+"\nFEE: "+fee+"\n\nMODE OF PAYMENT: "+modeOfPayment
                    +"\n"+paymentDescription+"\nTOTAL FEE: "+totalFee);
        }

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

