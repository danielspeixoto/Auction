package view.component;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ToolBarButton extends JButton {
	
	public ToolBarButton(String tooltip, String path) {
		super();
		
		this.setSize(32, 32);
        this.setToolTipText(tooltip);
        this.setBackground(new Color(234, 234, 234));
        this.setBorder((new EmptyBorder(0,0,0,0)));
        this.setFocusable(false);
        
        try {
			this.setIcon(new ImageIcon(ImageIO.read(new File(path))));
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseExited(MouseEvent e) {
				setBackground(new Color(234, 234, 234));
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				setBackground(new Color(210,210,210));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setBackground(new Color(234, 234, 234));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				setBackground(new Color(234, 234, 234));
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
	}
}