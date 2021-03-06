package mock;

import model.pojo.User;
import util.Convert;

import java.io.IOException;

public class UserDatabase extends Database {

    public static final int INDEX_EMAIL = 1;
    public static final int INDEX_PASSWORD = 3;
    public static final int INDEX_NAME = 2;
    public static final String PATH_USERS = "src//data//users.txt";

    // Se existe um usuário com esse email e senha,retorna o usuário,
    // caso não exista, retorna null
    public static User login(String email, String password) throws IOException {
        User user = null;
        String[] arr;
        String line = getData(PATH_USERS, INDEX_EMAIL, email);
        if (line != null) {
            arr = line.split(Database.SPLIT);
            if (arr[INDEX_PASSWORD].equals(password)) {
                user = Convert.userFrom(line);
            }
        }
        return user;
    }

    public static User getUser(int id) throws IOException {
        return Convert.userFrom(getData(PATH_USERS, INDEX_ID, String.valueOf(id)));
    }
}
