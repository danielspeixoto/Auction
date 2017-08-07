package contract;

import view.BaseView;

/**
 * Created by daniel on 22/07/17.
 */
public class Base {

    public interface View {
        void close();

        void showErrorDialog(String message);

        void changePanel(BaseView view);
    }

    public interface Presenter {
        void onError(String message);
    }

    public interface Model {

    }

}
