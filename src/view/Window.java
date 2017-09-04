package view;

import javax.swing.*;
import java.awt.*;


public class Window extends JFrame {

    private BaseView view;
    private Window parent;

    private Window(BaseView view) {
        super();
        this.view = view;
        setSize(800, 600);
        setContentPane(view);
        revalidate();
        setIconImage((new ImageIcon("src//images//icon.png")).getImage());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static Window create(BaseView view) {
        Window window = new Window(view);
        view.onPostCreated();
        window.setVisible(true);
        return window;
    }

    public void changePanel(BaseView view) {
        this.view = view;
        setContentPane(view);
        revalidate();
        view.onPostCreated();
    }

    public void fillScreen() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds(0, 0, screenSize.width, screenSize.height);
    }

    public void createForResult(BaseView view) {
        create(view).setParent(this);
    }

    public void setResult(int sender, Object object) {
        if (parent != null) {
            parent.getView().setResult(sender, object);
        } else {
            view.setResult(sender, object);
        }
    }

    public BaseView getView() {
        return view;
    }

    @Override
    public Window getParent() {
        return parent;
    }

    private void setParent(Window parent) {
        this.parent = parent;
    }
}
