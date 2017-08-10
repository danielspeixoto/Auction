package mock;

import model.pojo.User;

public class AccountDatabase extends Database  {
	
	public static final int INDEX_USER_ID = 0;
    public static final int INDEX_BALANCE = 1;
    public static final int INDEX_FRONZEN_BALANCE = 2;
    public static final String PATH_ACCOUNTS = "src//data//account.txt";

}