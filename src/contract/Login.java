package contract;


public class Login {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void login(String username, String password);

        void onLoginSuccess();
    }

    public interface Model extends Base.Model {
        void login(String username, String password);
    }
}
