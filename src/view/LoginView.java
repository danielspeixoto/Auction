package view;

import contract.Login;
import presenter.LoginPresenter;
import view.component.InputField;
import view.component.PasswordField;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginView extends BaseView implements Login.View {

    private InputField emailField;
    private PasswordField passwordField;
    private JButton loginButton;
    private JButton createAccountButton;

    private Login.Presenter presenter;

    public LoginView() {
        super();
        emailField = new InputField("Email");
        emailField.setPosition(25, 50);
        passwordField = new PasswordField("Senha");
        passwordField.setPosition(25, 100);
        loginButton = new JButton("Login");
        loginButton.setBounds(75, 160, 150, 30);
        createAccountButton = new JButton("Criar conta");
        createAccountButton.setBounds(75, 200, 150, 30);

        add(emailField);
        add(passwordField);
        add(createAccountButton);
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                presenter.login(
                        emailField.getText().toLowerCase().trim(),
                        passwordField.getText()
                );
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                changePanel(new CreateUserView());
            }
        });
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 280);
        frame.setResizable(false);
        frame.setTitle("Bem-Vindo!");
        presenter = new LoginPresenter(this);
    }
}
