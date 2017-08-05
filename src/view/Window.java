package view;

import javax.swing.*;

/**
 * Created by daniel on 02/08/17.
 */
public class Window extends JFrame {

    private BaseView view;

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
