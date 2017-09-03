package view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SimpleButton extends JButton {

	public SimpleButton(String text) {
		super(text);
		
		this.setSize(150, 30);
		this.setForeground(Color.DARK_GRAY);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.DARK_GRAY));
		this.setFocusable(false);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Color.DARK_GRAY);
				setBackground(Color.WHITE);
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
				setCursor(new Cursor(Cursor.HAND_CURSOR));
				
			}
		});
	}
}
