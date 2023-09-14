import javax.swing.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class Midterm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField productPrice;
    private JTextField productQuantity;

    public Midterm() {
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
        DecimalFormat decimal = new DecimalFormat("0.00");
        float price = Float.parseFloat(productPrice.getText());
        int quantity = Integer.parseInt(productQuantity.getText());
        Price product = new Price(price, quantity);
        String finalPrice = decimal.format(product.getTotalAmount());
        JOptionPane.showMessageDialog(null, "Product Price: Php"+price+"\nProduct Quantity: " +quantity+"\nFinal Price: Php"+finalPrice);
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public static void main(String[] args) {
        Midterm dialog = new Midterm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
