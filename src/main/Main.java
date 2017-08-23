package main;

import java.io.IOException;

import view.LoginView;
import view.Window;

public class Main {

    public static void main(String[] args) throws IOException {
        Window.create(new LoginView());
    }
}
