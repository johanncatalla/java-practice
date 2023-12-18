import javax.swing.*;
import java.awt.event.*;

public class Pizza extends JDialog {
    private JPanel contentPane;
    private JButton LOGINbtn;
    private JButton ADDORDERButton;
    private JButton CANCELButton;
    private JButton PAYButton;
    private JComboBox flavorCombo;
    private JTextField quantityField;
    private JRadioButton soloRadioButton;
    private JRadioButton doubleRadioButton;
    private JRadioButton familyRadioButton;
    private JTextField priceField;
    private JTextField totalField;
    private JLabel welcomeLabel;
    private JTextArea ordersArea;
    private JButton buttonOK;
    private JButton buttonCancel;
    private String flavor;
    private int quantity;
    private String size, customerType;
    private float price, total, totalOrder, change, discounted;
    private Order order = new Order();
    private boolean check = false;

    public Pizza() {
        quantityField.setEditable(false);
        priceField.setEditable(false);
        totalField.setEditable(false);

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

        LOGINbtn.addActionListener( e -> onLogin() );
        flavorCombo.addActionListener( e -> onFlavor() );
        soloRadioButton.addActionListener( e -> onSolo() );
        doubleRadioButton.addActionListener( e -> onDouble() );
        familyRadioButton.addActionListener( e -> onFamily() );
        ADDORDERButton.addActionListener( e -> addOrder() );
        ordersArea.setText("ORDER");
        PAYButton.addActionListener( e -> onPay() );
    }

    private String receipt = "";

    private void onPay() {
        int res = JOptionPane.showConfirmDialog(null, "Are there any Discount?", "Discount", JOptionPane.YES_NO_OPTION);
        if (res == 1) {
            receipt = "\n\nTYPE OF CUSTOMER: REGULAR\nDISCOUNT: "+order.getDiscount("Regular")+"\nTOTAL AMOUNT: "+totalOrder;
            ordersArea.setText(msg+totalMsg+receipt);
            check = false;
            while(!check) {
                float cash = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter cash:"));
                check = order.checkPayment(cash, totalOrder);
                if (check) {
                    receipt += "\nCASH: "+cash+"\nCHANGE: "+order.getChange(cash);
                    ordersArea.setText(msg+totalMsg+receipt);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT CASH", "PAYMENT", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else {
            Object[] customer = {"STUDENT", "SENIOR CITIZEN"};
            customerType = JOptionPane.showInputDialog(null, "Choose Customer:\n", "PAYMENT", JOptionPane.INFORMATION_MESSAGE, null, customer, customer[0]).toString();
            discounted = order.getDiscountedPrice();
            receipt = "\n\nTYPE OF CUSTOMER: "+customerType+"\nDISCOUNT: "+order.getDiscount(customerType)+"\nTOTAL AMOUNT: "+order.getDiscountedPrice();
            ordersArea.setText(msg+totalMsg+receipt);
            check = false;
            while(!check) {
                float cash = Float.parseFloat(JOptionPane.showInputDialog(null, "Enter cash:"));
                check = order.checkPayment(cash, order.getDiscountedPrice());
                if (check) {
                    receipt += "\nCASH: "+cash+"\nCHANGE: "+(cash-order.getDiscountedPrice());
                    ordersArea.setText(msg+totalMsg+receipt);
                    break;
                } else {
                    JOptionPane.showMessageDialog(null, "INSUFFICIENT CASH", "PAYMENT", JOptionPane.WARNING_MESSAGE);
                }
            }
        }


    }

    private String msg = "";
    private String totalMsg = "";
    private void addOrder() {
        order.addOrder();
        msg += "\n"+order.getQuantity()+" "+order.getSize()+"\t"+order.getPrice()+"\t"+order.getTotalPrice(price);
        totalOrder = order.getTotalOrder();
        totalMsg = "\n\nTOTAL AMOUNT: "+totalOrder+"";
        ordersArea.setText(msg+totalMsg);
    }

    private void setOrder() {
        order.setFlavor(flavor);
        order.setSize(size);
        order.setQuantity(quantity);
    }

    private void onSolo() {
        size = "Solo";
        setOrder();
        price = order.getPrice();
        total = order.getTotalPrice(price);
        priceField.setText(price+"");
        totalField.setText(total+"");
    }

    private void onDouble() {
        size = "Double";
        setOrder();
        price = order.getPrice();
        total = order.getTotalPrice(price);
        priceField.setText(price+"");
        totalField.setText(total+"");
    }

    private void onFamily() {
        size = "Family";
        setOrder();
        price = order.getPrice();
        total = order.getTotalPrice(price);
        priceField.setText(price+"");
        totalField.setText(total+"");
    }

    private void onFlavor() {
        quantityField.setText("");
        priceField.setText("");
        totalField.setText("");

        flavor = flavorCombo.getSelectedItem().toString();
        quantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Pizza Flavor: "+flavor+"\nEnter number of orders:\n"));
        quantityField.setText(quantity+"");
    }

    private void onLogin() {
        String name = JOptionPane.showInputDialog(null, "Enter Name:");
        welcomeLabel.setText("Welcome "+name);
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
        Pizza dialog = new Pizza();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
