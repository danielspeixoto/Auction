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
        nameField.setPosition(25, 30);
        nameField.textField.setSize(250, 30);
        nameField.setSize(250,50);
        emailField = new InputField("Email");
        emailField.setPosition(25, 90);
        emailField.setSize(250,50);
        emailField.textField.setSize(250, 30);
        passwordField = new PasswordField("Senha");
        passwordField.setPosition(25, 150);
        passwordField.setSize(250,50);
        passwordField.textField.setSize(250, 30);
        repeatPasswordField = new PasswordField("Repita a senha");
        repeatPasswordField.setLocation(25, 210);
        repeatPasswordField.setSize(250,50);
        repeatPasswordField.textField.setSize(250, 30);
        createAccountButton = new SimpleButton("Criar conta");
        createAccountButton.setBounds(75, 360, 150, 30);

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
        frame.setSize(300, 450);
        frame.setTitle("Criar Conta");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
    }
}
