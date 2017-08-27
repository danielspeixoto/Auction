package view;

import contract.Login;
import presenter.LoginPresenter;
import view.component.InputField;
import view.component.PasswordField;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import view.component.*;

public class LoginView extends BaseView implements Login.View {

    private InputField emailField;
    private PasswordField passwordField;
    private SimpleButton loginButton;
    private SimpleButton createAccountButton;
    private JPanel logoPanel;
    private JLabel logo;
    private JLabel titleLabel;

    private Login.Presenter presenter;

    public LoginView() throws IOException {
        super();
        logoPanel = new JPanel();  
        logoPanel.setLayout(null);  
        logoPanel.setBounds(75, 30, 150, 170);       
        logo = new JLabel(new ImageIcon(ImageIO.read(new File("src//images//auction.png"))));
        logo.setBounds(11, 0, 128, 128);
        titleLabel = new JLabel("Leilões & Cia");
        titleLabel.setFont(new Font("Arial", Font.ITALIC, 15));
        titleLabel.setBounds(15, 135, 128, 30);
        logoPanel.add(logo);
        logoPanel.add(titleLabel);
        
        emailField = new InputField("Email");
        emailField.setPosition(22, 210);
        passwordField = new PasswordField("Senha");
        passwordField.setPosition(22, 260);

        passwordField.getTextField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        loginButton = new SimpleButton("Login");
        loginButton.setBounds(75, 320, 150, 30);
        createAccountButton = new SimpleButton("Criar conta");
        createAccountButton.setBounds(75, 360, 150, 30);
        
        add(loginButton);
        add(logoPanel);
        add(emailField);
        add(passwordField);
        add(createAccountButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.changePanel(new CreateUserView());
            }
        });
    }

    private void login() {
        presenter.login(
                emailField.getText().toLowerCase().trim(),
                passwordField.getText()
        );
    }

    @Override
    public void onPostCreated() {
        super.onPostCreated();
        frame.setSize(300, 450);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Bem-Vindo!");
        presenter = new LoginPresenter(this);
    }
}
