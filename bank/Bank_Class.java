import javax.swing.*;
import java.awt.event.*;

public class Bank_Class extends JDialog {
    private JPanel contentPane;
    private JButton depositBtn;
    private JButton withdrawBtn;
    private JTextField depositAmt;
    private JTextField withdrawAmt;
    private JTextField savingsBalance;
    private JTextField currentBalance;
    private JComboBox depositCombo;
    private JComboBox withdrawCombo;
    private JTextArea transactions;

    public Bank_Class() {

        savingsBalance.setEditable(false);
        currentBalance.setEditable(false);
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(depositBtn);

        depositBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onDeposit();
            }
        });

        withdrawBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onWithdraw();
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

        transactions.setText(msg);
    }

    private String msg = "TRANSAC.\tACCOUNT\tTYPE\tAMOUNT\tBALANCE";
    private Inheritance_Sample bank = new Inheritance_Sample();
    private void onDeposit() {
        float deposit = Float.parseFloat(depositAmt.getText());
        String accType = depositCombo.getSelectedItem().toString();
        bank.deposit(accType, deposit);
        if (accType == "SAVINGS") {
            savingsBalance.setText(bank.getSavingsBalance()+"");
            msg += "\nNo. "+bank.getTransactionNo()+"\t"+accType+"\tDEPOSIT\t"+deposit+"\t"+bank.getSavingsBalance();
            bank.setTransactionHistory(msg);
        } else {
            currentBalance.setText(bank.getCurrentBalance()+"");
            msg += "\nNo. "+bank.getTransactionNo()+"\t"+accType+"\tDEPOSIT\t"+deposit+"\t"+bank.getCurrentBalance();
            bank.setTransactionHistory(msg);
        }

        transactions.setText(bank.getTransactionHistory());
    }

    private void onWithdraw() {
        float withdraw = Float.parseFloat(withdrawAmt.getText());
        String accType = withdrawCombo.getSelectedItem().toString();

        if (accType == "SAVINGS") {
            if (bank.checkSavingsBalance(withdraw)) {
                bank.withdraw(accType, withdraw);
                bank.setLast_accType(accType);
                bank.setLast_amt(withdraw);
                savingsBalance.setText(bank.getSavingsBalance()+"");
                msg += "\nNo. "+bank.getTransactionNo()+"\t"+bank.getLastAcc()+"\tWITHDRAW\t"+bank.getLastAmt()+"\t"+bank.getSavingsBalance();
                bank.setTransactionHistory(msg);
                transactions.setText(bank.getTransactionHistory());
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Savings Balance", "Cannot Withdraw", JOptionPane.WARNING_MESSAGE);
            }
        } else if (accType == "CURRENT") {
            if (bank.checkCurrentBalance(withdraw)) {
                bank.withdraw(accType, withdraw);
                currentBalance.setText(bank.getCurrentBalance()+"");
                msg += "\nNo. "+bank.getTransactionNo()+"\t"+accType+"\tWITHDRAW\t"+withdraw+"\t"+bank.getCurrentBalance();
                bank.setTransactionHistory(msg);
                transactions.setText(bank.getTransactionHistory());
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient Current Balance", "Cannot Withdraw", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Bank_Class dialog = new Bank_Class();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
