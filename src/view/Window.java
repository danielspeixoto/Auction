package view;

import javax.swing.*;


public class Window extends JFrame {

    private Window(BaseView view) {
        super();
        setContentPane(view);
        revalidate();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void create(BaseView view) {
        Window window = new Window(view);
        view.onPostCreated();
        window.setVisible(true);
    }

    public void changePanel(BaseView view) {
        setContentPane(view);
        revalidate();
        view.onPostCreated();
    }
}
