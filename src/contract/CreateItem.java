package contract;

import model.pojo.Item;

public class CreateItem {

    public interface View extends Base.View {
    }

    public interface Presenter extends Base.Presenter {
        void createItem(Item item);

        void onCreateSuccess();
    }

    public interface Model extends Base.Model {
        void createItem(Item item);
    }
}
