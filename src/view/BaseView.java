package view;

import contract.Base;

import javax.swing.*;


public abstract class BaseView extends JPanel implements Base.View {

    protected Window frame;
    protected Object result;

    public BaseView() {
        setLayout(null);
    }

    @Override
    public void close() {
        frame.dispose();
    }

    @Override
    public void showErrorDialog(String message) {
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

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
