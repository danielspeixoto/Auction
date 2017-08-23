package view;

import contract.CreateUser;
import model.pojo.User;
import presenter.CreateUserPresenter;
import view.component.InputField;
import view.component.PasswordField;
import view.component.SimpleButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CreateUserView extends BaseView implements CreateUser.View {

    private InputField emailField;
    private PasswordField passwordField;
    private InputField nameField;
    private PasswordField repeatPasswordField;
    private SimpleButton createAccountButton;

    private CreateUser.Presenter presenter;

    public CreateUserView() {
        super();
        nameField = new InputField("Nome");
        nameField.setPosition(25, 50);
        emailField = new InputField("Email");
        emailField.setPosition(25, 100);
        passwordField = new PasswordField("Senha");
        passwordField.setPosition(25, 150);
        repeatPasswordField = new PasswordField("Repita a senha");
        repeatPasswordField.setPosition(25, 200);
        createAccountButton = new SimpleButton("Criar conta");
        createAccountButton.setBounds(75, 280, 150, 30);

        add(emailField);
        add(passwordField);
        add(nameField);
        add(repeatPasswordField);
        add(createAccountButton);

        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (passwordField.getText().equals(repeatPasswordField.getText())) {
                    User user = new User(nameField.getText(),
                    emailField.getText(), passwordField.getText());
                    presenter.createUser(user);
                } else {
                    showErrorDialog("As senhas não coincidem");
                }
            }
        });

        presenter = new CreateUserPresenter(this);
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 400);
        frame.setTitle("Criar Conta");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
