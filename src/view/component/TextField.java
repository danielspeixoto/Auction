package view.component;

import javax.swing.*;


public abstract class TextField extends JPanel {

    public JTextField textField;
    private JLabel label;

    public TextField(String text) {
        super();
        setSize(250, 45);
        setLayout(null);
        label = new JLabel(text);
        label.setBounds(0, 0, 250, 15);
        add(label);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setPosition(int x, int y) {
        setBounds(x, y, 250, 45);
    }

    public String getText() {
        return textField.getText();
    }
}
