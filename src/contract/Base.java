package contract;

import view.BaseView;

/**
 * Created by daniel on 22/07/17.
 */
public class Base {

    interface View {
        void close();

        void showErrorDialog(String message);

        void changePanel(BaseView view);
    }

    interface Presenter {
        void onError(String message);
    }

    interface Model {

    }

}
