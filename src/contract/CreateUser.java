package contract;

import model.pojo.User;


public class CreateUser {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void createUser(User user);
        void onCreateSuccess(int user_id);
    }

    public interface Model extends Base.Model {
        void createUser(User user);
    }
}