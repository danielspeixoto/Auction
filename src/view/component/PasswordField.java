package view.component;

import javax.swing.*;

/**
 * Created by daniel on 02/08/17.
 */
public class PasswordField extends TextField {

    public PasswordField(String text) {
        super(text);
        textField = new JPasswordField(20);
        textField.setBounds(0, 20, 250, 25);
        add(textField);
    }

}
