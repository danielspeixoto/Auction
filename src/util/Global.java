package util;

import mock.AccountDatabase;
import mock.UserDatabase;
import model.pojo.Account;
import model.pojo.User;

import java.io.*;

public class Global {

    private static final String PATH_SESSION = "src//data//session.txt";
    private static User currentUser;

    public static User getCurrentUser() {
        try {
            currentUser = UserDatabase.getUser(currentUser.getId());
            Account account = AccountDatabase.getAccount(currentUser.getId());
            currentUser.setAccount(account);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
            	try {
            		currentUser = Convert.userFrom(currentLine);
                    Account account = AccountDatabase.getAccount(currentUser.getId());
                    currentUser.setAccount(account);               
            	} catch (IOException e) {
            		e.printStackTrace();
            	} 
            	return true;
            }
            return false;
        }
        return true;
    }
    
    public static void logout() throws IOException {
		FileWriter writer = new FileWriter(PATH_SESSION, false);
		BufferedWriter bufferedWriter = new BufferedWriter(writer);
		bufferedWriter.write(new String(""));
		bufferedWriter.close();
		writer.close();
		System.exit(0);
    }
}
