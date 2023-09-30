import javax.swing.*;
import java.awt.event.*;
import java.util.Objects;

public class Pizza extends JDialog {
    Store store = new Store();
    float price, payment = 0, change, total;
    int quantity;
    String orderType, size, flavor;
    boolean checkPay, payStatus;
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JRadioButton takeOutRadioButton;
    private JRadioButton dineInRadioButton;
    private JComboBox flavorCombo;
    private JTextField quantityField;
    private JRadioButton familyRadioButton;
    private JRadioButton soloRadioButton;
    private JRadioButton doubleRadioButton;
    private JLabel priceField;
    private JLabel totalField;

    public Pizza() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pay();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                printReceipt();
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

        soloRadioButton.addActionListener(e -> onSolo());
        doubleRadioButton.addActionListener(e -> onDouble());
        familyRadioButton.addActionListener(e -> onFamily());
        dineInRadioButton.addActionListener(e -> onDine());
        takeOutRadioButton.addActionListener(e -> onTake());
    }

    private void onDine() {
        orderType = "Dine In";
    }

    private void  onTake() {
        orderType = "Take Out";
    }

    private void onSolo() {
        size = "Solo";
        flavor = Objects.requireNonNull(flavorCombo.getSelectedItem().toString());
        price = store.getPrice(flavor);
        quantity = Integer.parseInt(quantityField.getText());

        priceField.setText(""+price);
        totalField.setText(""+(price*quantity));
    }
    private void onDouble() {
        size = "Double";
        flavor = Objects.requireNonNull(flavorCombo.getSelectedItem().toString());
        price = store.getPrice(flavor) + 75;
        quantity = Integer.parseInt(quantityField.getText());

        priceField.setText(""+price);
        totalField.setText(""+(price*quantity));
    }
    private void onFamily() {
        size = "Family";
        flavor = Objects.requireNonNull(flavorCombo.getSelectedItem().toString());
        price = store.getPrice(flavor) + 150;
        quantity = Integer.parseInt(quantityField.getText());

        priceField.setText(""+price);
        totalField.setText(""+(price*quantity));
    }
    private void pay() {
        payStatus = true;
        Store store = new Store();
        payment = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter Cash: "));
        total = price * quantity;
        checkPay = store.checkPrice(payment, total);
        if (checkPay) {
            change = store.getChange(payment, total);
            JOptionPane.showMessageDialog(null, "Change: "+change);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient Amount!!!");
        }
    }

    private void printReceipt() {
        String flavor = Objects.requireNonNull(flavorCombo.getSelectedItem().toString());
        total = price * quantity;
        change = store.getChange(payment, total);
        if (!payStatus) {
            JOptionPane.showMessageDialog(null, "ORDER TYPE: "+orderType+"\nFLAVOR: "+flavor
                    +"\nSIZE: "+size+"\nQUANTITY: "+quantity+"\nTOTAL AMOUNT: "+total+"\nCASH: pending payment"+"\nCHANGE: pending payment");
        } else if (!checkPay) {
            JOptionPane.showMessageDialog(null, "ORDER TYPE: "+orderType+"\nFLAVOR: "+flavor
                    +"\nSIZE: "+size+"\nQUANTITY: "+quantity+"\nTOTAL AMOUNT: "+total+"\nCASH: Insufficient Amount"+"\nCHANGE: Insufficient Amount");
        } else {
            JOptionPane.showMessageDialog(null, "ORDER TYPE: "+orderType+"\nFLAVOR: "+flavor
                    +"\nSIZE: "+size+"\nQUANTITY: "+quantity+"\nTOTAL AMOUNT: "+total+"\nCASH: "+payment+"\nCHANGE: "+change);
        }

    }

    private void onCancel() {
        dispose();
    }

    public static void main(String[] args) {
        Pizza dialog = new Pizza();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
