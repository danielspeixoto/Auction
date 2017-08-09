package view;

import contract.Base;

import javax.swing.*;


public abstract class BaseView extends JPanel implements Base.View {

    protected Window frame;

    public BaseView() {
        setLayout(null);
    }

    @Override
    public void close() {
        frame.dispose();
    }

    @Override
    public void showErrorDialog(String message) {
        System.out.println("aqui");
        JOptionPane.showMessageDialog(frame, message);
    }

    @Override
    public void changePanel(BaseView view) {
        frame.changePanel(view);
    }

    // Executa o código depois do panel ser adicionado
    // à Window
    public void onPostCreated() {
        frame = (Window) SwingUtilities.windowForComponent(this);
    }
}
