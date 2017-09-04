package main;

import view.LoginView;
import view.Window;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LoginView view = new LoginView();
        Window.create(view);
    }
}
