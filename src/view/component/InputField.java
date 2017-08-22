package view.component;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class InputField extends TextField {
	
	private Border line;
	private Border empty;
	private Border compound;
	
    public InputField(String text) {
        super(text);
        line = new LineBorder(Color.DARK_GRAY);
        empty = new EmptyBorder(0,5,0,5);
        compound = new CompoundBorder(line, empty);
        
        textField = new JTextField(20);
        textField.setBounds(0, 20, 250, 25);
        textField.setForeground(Color.DARK_GRAY);
        textField.setBorder(compound);
        
        textField.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				textField.setBorder(new CompoundBorder(new LineBorder(Color.DARK_GRAY), empty));
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				textField.setBorder(new CompoundBorder(new LineBorder(new Color(57, 163, 198)), empty));
			}
		});
        add(textField);
    }

}
