package util;

import model.pojo.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Global {

    private static final String PATH_SESSION = "src//data//session.txt";
    private static User currentUser;

    public static User getCurrentUser() {
        return currentUser;
    }

    // Loga o usuário e salva seus dados no computador
    public static void setCurrentUser(User user) {
        currentUser = user;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    WriteToFile.write(PATH_SESSION, user.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    // Verifica se já há algum usuário logado, não havendo tenta
    // ver se há algum salvo no computador, não havendo também
    // retorna false
    public static boolean isLogged() {
        if (currentUser == null) {
            String currentLine = "";
            try {
                FileReader reader = new FileReader(PATH_SESSION);
                BufferedReader bufferedReader = new BufferedReader(reader);
                currentLine = bufferedReader.readLine();
                bufferedReader.close();
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (currentLine != null) {
                currentUser = Convert.userFrom(currentLine);
                return true;
            }
            return false;
        }
        return true;
    }
}
