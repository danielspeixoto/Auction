package util;

import mock.ItemDatabase;
import mock.UserDatabase;
import model.pojo.Item;
import model.pojo.User;

public class Convert {

    // Cria um user baseando-se na linha que contém seus dados
    public static User userFrom(String string) {
        String arr[] = string.split(",");
        return new User(Integer.valueOf(arr[UserDatabase.INDEX_ID]),
                arr[UserDatabase.INDEX_NAME], arr[UserDatabase.INDEX_EMAIL],
                arr[UserDatabase.INDEX_PASSWORD]);
    }

    public static Item itemFrom(String string) {
        String arr[] = string.split(",");
        return new Item(Integer.valueOf(arr[ItemDatabase.INDEX_ID]),
                Integer.valueOf(arr[ItemDatabase.INDEX_OWNER]), arr[ItemDatabase.INDEX_DESCRIPTION]);
    }
}
