package view.component;

import model.pojo.Auction;
import model.pojo.Item;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AuctionCellRenderer extends JPanel implements ListCellRenderer<Auction> {

    private JLabel nameText;
    private JLabel descriptionText;

    // A parte visual de cada item da lista deve ser definida aqui
    public AuctionCellRenderer() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        nameText = new JLabel();
        nameText.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        Border border = nameText.getBorder();
        Border margin = new EmptyBorder(10,10,0,10);
        nameText.setBorder(new CompoundBorder(border, margin));
        descriptionText = new JLabel();
        descriptionText.setBorder(new CompoundBorder(descriptionText.getBorder(),
                new EmptyBorder(10,10,5,10)));
        add(nameText);
        add(descriptionText);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Auction> list, Auction value,
                                                  int index, boolean isSelected, boolean cellHasFocus) {
        Item item = value.getItem();
        AuctionCellRenderer cell = new AuctionCellRenderer();
        cell.nameText.setText(item.getName());
        cell.descriptionText.setText(item.getDescription());
        if(index % 2 == 1) {
            cell.setBackground(Color.LIGHT_GRAY);
        }
        return cell;
    }
}
