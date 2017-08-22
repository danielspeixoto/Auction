package view.component;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class SimpleButton extends JButton {

	public SimpleButton(String text) {
		super(text);
		
		this.setBounds(75, 150, 150, 30);
		this.setForeground(Color.DARK_GRAY);
		this.setBackground(Color.WHITE);
		this.setBorder(new LineBorder(Color.DARK_GRAY));
		this.setFocusable(false);
		
		this.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseExited(MouseEvent e) {
				setForeground(Color.DARK_GRAY);
				setBackground(Color.WHITE);	
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setForeground(Color.WHITE);
				setBackground(Color.DARK_GRAY);
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
