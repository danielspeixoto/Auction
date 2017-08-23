package util;
import mock.AccountDatabase;
import model.pojo.Account;

public class ConvertAccount {

    public static Account accountFrom(String string) {
        String arr[] = string.split(",");
        return new Account(Integer.valueOf(arr[AccountDatabase.INDEX_USER_ID]),
               Double.valueOf(arr[AccountDatabase.INDEX_BALANCE]),Double.valueOf(arr[AccountDatabase.INDEX_FRONZEN_BALANCE]));
    }	
}
