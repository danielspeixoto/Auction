package contract;

import model.pojo.Realty;

public class CreateRealty {

    public interface View extends Base.View {
        void onCreateSuccess(Realty realty);
    }

    public interface Presenter extends Base.Presenter {
        void createRealty(Realty realty);
        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createRealty(Realty realty);
    }
}
