package main;

import mock.AuctionDatabase;
import util.BackgroundTask;
import view.LoginView;
import view.Window;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        LoginView view = new LoginView();
        Window.create(view);
        BackgroundTask.addSlowSubscriber(new Runnable() {
            @Override
            public void run() {
                AuctionDatabase.checkIfFinished();
            }
        });
    }
}
