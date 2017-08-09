package contract;

import model.pojo.Account;
import model.pojo.User;

public class CreateAccount {
	
	public interface View extends Base.View {
		
	}
	
	public interface Presenter extends Base.Presenter {
		void createAccount(Account account, User user);
		void onCreateSuccsses();
	}
	
	public interface Model extends Base.Model {
		void createAccount(Account account, User user);	
	}
}
