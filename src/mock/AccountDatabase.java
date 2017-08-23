package mock;

import java.io.IOException;

import model.pojo.Account;
import util.ConvertAccount;
import util.Global;

public class AccountDatabase extends Database  {
	
	public static final int INDEX_USER_ID = 1;
    public static final int INDEX_BALANCE = 2;
    public static final int INDEX_FRONZEN_BALANCE = 3;
    public static final String PATH_ACCOUNTS = "src//data//account.txt";
    
    public static Account getAccount(int userId) throws IOException {
    	String line = getData(AccountDatabase.PATH_ACCOUNTS, AccountDatabase.INDEX_USER_ID, Integer.toString(userId));
    	Account account = null;
    	account = ConvertAccount.accountFrom(line);
    	return account;
    }

}