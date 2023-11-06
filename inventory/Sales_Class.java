import javax.swing.*;
import java.awt.event.*;

public class Sales_Class extends JDialog {
    private JPanel contentPane;
    private JButton PURCHASEITEMButton;
    private JButton CLEARITEMDETAILSButton;
    private JButton SETITEMDETAILSButton;
    private JButton CLOSEButton;
    private JTextField availableItemField;
    private JTextField prodNameField;
    private JTextField priceField;
    private JTextField quantityField;
    private JTextArea purchaseHistoryArea;
    private JButton buttonOK;
    String inputName, inputHistory;
    int inputQuantity, inputPurchase, availableItems;
    double inputPrice;
    Item_Class item;
    Inventory_Class inventory = new Inventory_Class();

    public Sales_Class() {
        availableItemField.setEditable(false);
        prodNameField.setEditable(false);
        priceField.setEditable(false);
        quantityField.setEditable(false);

        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        SETITEMDETAILSButton.addActionListener( e -> onSetItemDetails() );
        PURCHASEITEMButton.addActionListener( e -> onPurchase() );
        CLEARITEMDETAILSButton.addActionListener( e -> onClear() );
        CLOSEButton.addActionListener( e -> onClose() );

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

    private void onSetItemDetails() {
        quantityField.setText("");
        inputName = JOptionPane.showInputDialog(null, "Enter product name: ");
        prodNameField.setText(inputName);
        inputPrice = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter product price: "));
        priceField.setText(inputPrice+"");
        inputQuantity = Integer.parseInt(JOptionPane.showInputDialog(null, "Initial number of items: "));
        availableItemField.setText(inputQuantity+"");
        item = new Item_Class(inputName, inputPrice, inputQuantity);
    }

    private void onPurchase() {
        inputPurchase = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter quantity: "));
        quantityField.setText(inputPurchase+"");
        if (inputPurchase <= 0) {
            JOptionPane.showMessageDialog(null, "INVALID INPUT", "INVENTORY", JOptionPane.WARNING_MESSAGE);
        } else {
            boolean check = item.checkStocks(inputPurchase);
            if (check) {
                item.purchaseItem(inputPurchase);
                availableItems = item.getAvailableItems();
                availableItemField.setText(availableItems+"");
                JOptionPane.showMessageDialog(null,"PRODDUCT NAME: "+item.getProductName()
                                +"\nPRODUCT PRICE: "+item.getProductPrice()+"\nPRODUCT QUANTITY: "+item.getProductQuantity()
                                +"\nTOTAL AMOUNT: "+item.getTotalAmount());
                inventory.setPurchaseHistory("Purchase No. "+inventory.getTransactionNum()+": "+item.getLastPurchase());
                inventory.addTransactionNum();
                purchaseHistoryArea.setText(inventory.getPurchaseHistory());
            } else {
                JOptionPane.showMessageDialog(null, "INSUFFICIENT STOCKS", "INVENTORY", JOptionPane.WARNING_MESSAGE);
            }
        }

    }

    private void onClear() {
        item.clearItems();
        prodNameField.setText("");
        priceField.setText("");
        quantityField.setText("");
        availableItemField.setText("");
        purchaseHistoryArea.setText("");
    }

    private void onClose() {
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Sales_Class dialog = new Sales_Class();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
