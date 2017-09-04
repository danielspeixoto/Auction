package contract;


import model.pojo.User;

public class Login {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void login(String username, String password);
        void onLoginSuccess(User user);
    }

    public interface Model extends Base.Model {
        void login(String username, String password);
    }
}
