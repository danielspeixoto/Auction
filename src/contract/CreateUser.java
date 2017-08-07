package contract;

import model.pojo.User;

/**
 * Created by daniel on 02/08/17.
 */
public class CreateUser {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void createUser(User user);

        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createUser(User user);
    }
}