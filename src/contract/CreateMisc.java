package contract;

import model.pojo.Misc;

public class CreateMisc {

    public interface View extends Base.View {
        void onCreateSuccess(Misc misc);
    }

    public interface Presenter extends Base.Presenter {
        void createMisc(Misc misc);
        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createMisc(Misc misc);
    }
}
