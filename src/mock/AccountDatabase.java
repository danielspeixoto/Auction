package mock;

import model.pojo.Account;
import util.Convert;

import java.io.IOException;
import java.util.StringTokenizer;

public class AccountDatabase extends Database  {
	
	public static final int INDEX_USER_ID = 1;
    public static final int INDEX_BALANCE = 2;
    public static final int INDEX_FRONZEN_BALANCE = 3;
    public static final String PATH_ACCOUNTS = "src//data//account.txt";
    
    public static Account getAccount(int userId) throws IOException {
    	String line = getData(AccountDatabase.PATH_ACCOUNTS, AccountDatabase.INDEX_USER_ID, Integer.toString(userId));
    	Account account = Convert.accountFrom(line);
    	return account;
    }

    public static double injectMoney(Account account, double value) throws Exception {
        String currentLine = Database.getData(AccountDatabase.PATH_ACCOUNTS, AccountDatabase.INDEX_USER_ID,
                Integer.toString(account.getUserId()));
        String currentBalance = currentLine.split(Database.SPLIT)[AccountDatabase.INDEX_BALANCE];
        double newBalance = Double.parseDouble(currentBalance) + value;
        StringTokenizer str = new StringTokenizer(currentLine,Database.SPLIT);
        String newLine = str.nextToken();
        for (int i = 1; str.hasMoreTokens(); i++) {
            if(i == 2) {
                newLine += Database.SPLIT + Double.toString(newBalance);
                str.nextToken();
            } else {
                newLine += Database.SPLIT + str.nextToken();
            }
        }

        Database.replaceLine(AccountDatabase.PATH_ACCOUNTS, currentLine, newLine);
        return newBalance;
    }

    public static void update(Account account) throws IOException {
        update(PATH_ACCOUNTS, account, account.getUserId());
    }


}