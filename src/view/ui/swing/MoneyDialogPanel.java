package view.ui.swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Money;
import model.Number;
import view.ui.CurrencyDialog;
import view.ui.MoneyDialog;

public class MoneyDialogPanel extends JPanel implements MoneyDialog {

    private String amount;
    private CurrencyDialog currencyDialog;

    public MoneyDialogPanel() {
        super(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    public void show() {
        this.amount = "100";
        this.createComponents();
    }

    private JTextField createAmountField() {
        final JTextField textField = new JTextField(10);
        textField.setText(amount);
        textField.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent ke) {
            }

            @Override
            public void keyPressed(KeyEvent ke) {
            }

            @Override
            public void keyReleased(KeyEvent ke) {
                amount = textField.getText();
            }
        });
        return textField;
    }

    private JPanel createCurrencyDialog() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel();
        currencyDialog = panel;
        panel.show();
        return panel;
    }

    private void createComponents() {
        this.add(createAmountField());
        this.add(createCurrencyDialog());
    }

    @Override
    public Money getMoney() {
        return new Money(new Number(Double.parseDouble(amount)), currencyDialog.getCurrency());
    }

}