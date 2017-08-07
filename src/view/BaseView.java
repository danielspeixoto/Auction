package view;

import javax.swing.*;

/**
 * Created by daniel on 02/08/17.
 */
public abstract class BaseView extends JPanel {

    protected Window frame;

    public BaseView() {
        setLayout(null);
    }

    public void close() {
        frame.dispose();
    }

    public void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(getParent(), message);
    }

    public void onPostCreated() {
        frame = (Window) SwingUtilities.windowForComponent(this);
    }

    public void changePanel(BaseView view) {
        frame.changePanel(view);
    }
}
