package util;
import mock.AccountDatabase;
import mock.Database;
import model.pojo.Account;

public class ConvertAccount {

    public static Account accountFrom(String string) {
        String arr[] = string.split(Database.SPLIT);
        return new Account(Integer.valueOf(arr[AccountDatabase.INDEX_USER_ID]),
               Double.valueOf(arr[AccountDatabase.INDEX_BALANCE]),Double.valueOf(arr[AccountDatabase.INDEX_FRONZEN_BALANCE]));
    }	
}
