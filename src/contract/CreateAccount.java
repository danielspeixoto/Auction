package contract;

import model.pojo.Account;
import model.pojo.User;

public class CreateAccount {
	
	public interface View extends Base.View {
		void createAccount(Account account, int user_id);
		void onCreateSuccess();
	}
	
	public interface Presenter extends Base.Presenter {
		void createAccount(Account account, int user_id);
		void onCreateSuccess();
	}
	
	public interface Model extends Base.Model {
		void createAccount(Account account);	
	}
}