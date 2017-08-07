package mock;

import model.pojo.User;

import java.io.*;


public class Database {

    public static final int ERROR = -1;
    private static final int INDEX_EMAIL = 1;
    private static final int INDEX_PASSWORD = 3;
    private static final int INDEX_NAME = 2;
    private static final int INDEX_ID = 0;
    private static final String PATH_USERS = "src//data//users.txt";
    private static int usersId = 1;

    static {
        setLastId();
    }

    // Olha todo o documento e verifica qual foi o último id inserido
    // Recuperando seu valor, coloca em usersId
    private static void setLastId() {
        try (FileReader reader = new FileReader(PATH_USERS);
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            String last = "1", line;
            while ((line = bufferedReader.readLine()) != null) {
                last = line;
            }
            usersId = Integer.valueOf(last.split(",")[INDEX_ID]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retorna o id do usuário
    public static int insert(User user) throws IOException {
        FileWriter writer = new FileWriter(PATH_USERS, true);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        bufferedWriter.write(++usersId + "," +
                user.getEmail() + "," + user.getName() + "," + user.getPassword() + "\n");
        bufferedWriter.close();
        writer.close();
        return usersId;
    }

    public static User getUser(int id) throws IOException {
        User user = null;
        FileReader reader = new FileReader(PATH_USERS);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String currentLine;
        while ((currentLine = bufferedReader.readLine()) != null) {
            if (currentLine.charAt(0) == id) {
                user = stringToUser(currentLine);
                break;
            }
        }
        bufferedReader.close();
        reader.close();
        return user;
    }

    // Dá a linha que contêm os dados de um determinado usuário
    public static String getUserLine(String email) throws IOException {
        FileReader reader = new FileReader(PATH_USERS);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String currentLine;
        String[] arr;
        while ((currentLine = bufferedReader.readLine()) != null) {
            arr = currentLine.split(",");
            if (arr[INDEX_EMAIL].equals(email)) {
                break;
            }
        }
        bufferedReader.close();
        reader.close();
        return currentLine == null ? "" : currentLine;
    }

    // Se existe um usuário com esse email e senha,retorna o usuário,
    // caso não exista, retorna null
    public static User login(String email, String password) throws IOException {
        User user = null;
        String[] arr;
        String line = getUserLine(email);
        if (!line.equals("")) {
            arr = line.split(",");
            if (arr[INDEX_PASSWORD].equals(password)) {
                user = stringToUser(line);
            }
        }
        return user;
    }

    // Cria um user baseando-se na linha que contém seus dados
    private static User stringToUser(String str) {
        String arr[] = str.split(",");
        return new User(Integer.valueOf(arr[INDEX_ID]), arr[INDEX_NAME], arr[INDEX_EMAIL], arr[INDEX_PASSWORD]);
    }

}
